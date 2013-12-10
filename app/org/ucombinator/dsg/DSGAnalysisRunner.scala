package org.ucombinator.dsg
 
import tools.nsc.io.Directory
import org.ucombinator.utils.{StringUtils, AIOptions, FancyOutput}
import org.apache.commons.lang3.StringEscapeUtils
import org.ucombinator.utils.CommonUtils
import sys.process._
import scala.collection.mutable.ArrayBuffer

trait DSGAnalysisRunner {
  self: FancyOutput with DyckStateGraphMachinery =>

  import org.ucombinator.utils.StringUtils._
  
  // get he graph folder and created the folder if not exits
  def getGraphParentFolder(opts: AIOptions) : String = {
      import java.io._

      val apkGraphDirName = opts.graphDirName //opts.apkProjDir +  File.separator + graphsDirName
    val graphs = new Directory(new File(apkGraphDirName))
    if (!graphs.exists) {
      graphs.createDirectory(force = true)
      graphs.createFile(failIfExists = false)
    }
     
    val subfolderPath = apkGraphDirName //+ File.separator + StringUtils.trimFileName(opts.sexprDir)
    val subfolder = new Directory(new File(subfolderPath))
    if (!subfolder.exists) {
      subfolder.createDirectory(force = true)
      subfolder.createFile(failIfExists = false)
    }

   subfolderPath //+ File.separator + getGraphDumpFileName(opts) 
   
  }

  
  def dumpDSGGraph(opts: AIOptions, resultDSGs: List[DSG]): String = {

   import java.io._

   /* val graphs = new Directory(new File(graphsDirName))
    if (!graphs.exists) {
      graphs.createDirectory(force = true)
      graphs.createFile(failIfExists = false)
    }

    val subfolderPath = graphsDirName + File.separator + StringUtils.trimFileName(opts.sexprDir)
    val subfolder = new Directory(new File(subfolderPath))
    if (!subfolder.exists) {
      subfolder.createDirectory(force = true)
      subfolder.createFile(failIfExists = false)
    }*/


    val graphFolderPath =  getGraphParentFolder(opts) //
    val filePath = opts.dotFilePath// graphFolderPath+ File.separator +  //CommonUtils.getGraphDumpFileName(opts)  
    val file = new File(filePath)
    if (!file.exists()) {
      file.createNewFile()
    }
   
    val writer = new FileWriter(file)
    writer.write(prettyPrintDSGs(resultDSGs, graphFolderPath, opts))
    writer.close()
    
    // first tar dot file
        val graphZipCmdDot=   "/usr/bin/python ./pytar.py" + " " + opts.graphDirName + " graph.tar.gz"
       
    graphZipCmdDot !
    
    // val allTarCmdDot= "/usr/bin/python ./pytar.py" + " " + opts.apkProjDir + " all.tar.gz"
    //  graphZipCmdDot !
    
    // time to generate the svg file
    val dot2svgCmd :String = "dot -Tsvg " + opts.dotFilePath + " -o " + opts.svgFilePath 
    
    dot2svgCmd !
    
    // zip the graph folder
   // val graphZipCmd = "cd " + opts.graphDirName + " && " + "tar -zcvf graph.tar.gz ./* "
      val graphZipCmd =   "/usr/bin/python ./pytar.py" + " " + opts.graphDirName + " graph.tar.gz"
       
    graphZipCmd !
    
    val allTarCmd = "/usr/bin/python ./pytar.py" + " " + opts.apkProjDir + " all.tar.gz"
     
      allTarCmd !
    
    filePath
  }
  
  
  private def defaultStyle(state:S) : String = {
     if (state.sourceOrSinkState )
       " [style=filled, fillcolor=red, colorscheme=set312, URL=\"" //red
    else if(state.taintedState)
     " [style=filled, fillcolor=4, colorscheme=set312, URL=\"" //origin
    else 
       " [style=filled, fillcolor=2, colorscheme=set312, URL=\"" //yello
  }
  //http://www.graphviz.org/doc/info/colors.html#brewer
  
  private def genStyleStringForState(state: S, opts:AIOptions): String = {
   
    if(opts.doRegex ||  opts.doCheckList){
      val checklists = opts.checkList
      val stateTaintKind = state.taintKind
      val toDoCheckListColor = checklists intersect stateTaintKind
      
      if(state.matchRegex(opts.regex) ){
         " [style=filled, fillcolor=8, colorscheme=rdpu8, URL=\""
      } 
      else if(!toDoCheckListColor.isEmpty){
        " [style=filled, fillcolor=7, colorscheme=rdpu8, URL=\""
      }
      else defaultStyle(state)
      
    }else  defaultStyle(state) 
    
  } 
  
  def prettyPrintOneDSG(dsg: DSG, graphParentFolerPath: String, map: Map[S, Int], opts:AIOptions) : String = {
    
      val edges = dsg.edges  
     // var list: List[String] = List()
       val buf = new StringBuffer()
      for (Edge(s, g, s1) <- edges if s != s1) { 
        
      //nodes definite
      val node1 = prettyPrintState(s, map)
      val htmlPath = buildHtmlPath(s, map, graphParentFolerPath)
      
      val stylStr1 = genStyleStringForState(s,opts)
      
      buf.append("\"" + node1 + "\"" + stylStr1 + map(s) + ".html" + "\"]")
       buf.append(";\n")
      writeStateToHtmlfile(s, map, htmlPath)
      
      val node2 = prettyPrintState(s1, map)
      val htmlPath2 = buildHtmlPath(s1, map, graphParentFolerPath)
      
      val stylStr2 = genStyleStringForState(s1,opts)
      
      buf.append("\"" + node2 + "\"" + stylStr2  + map(s1) + ".html" + "\"]")
      writeStateToHtmlfile(s1, map, htmlPath2)
      buf.append(";\n")
      
      // edges and style
       buf.append("\"" + node1+ "\"")
      buf.append(" -> ")
      buf.append("\"" + node2+ "\"")

      if (!simplify) {
         g match {
          case Eps =>  buf.append(" [style=dotted, ")
          case _ => buf.append(" [ ")
        }
       
        buf.append(" label=\"")
        buf.append(truncateIfLong(StringEscapeUtils.escapeJava(g.toString), 100))
        buf.append("\"]")
      } 
      buf.append(";\n") 
      }
      buf.toString 
        
  }
  
  
   def genSToCounter(dsgs: List[DSG]) : Map[S, Int] = {
     var stateCounter = 0 
     val listOfMap = 
       dsgs.map(dsg => {
    	 val states: Set[S] = dsg.nodes.asInstanceOf[Set[S]] 
    	 val map: Map[S, Int] = states.map(s => { 
    	   stateCounter = stateCounter + 1 
    	   (s, stateCounter) }).toMap
    	 map
     }).flatten.toMap 
     listOfMap
  }
   
   def genCounterToSMap(map: Map[S, Int]) : Map[Int, S] = {
     map.foldLeft(Map[Int, S]())((res, pair) => {
       val state = pair._1
       val counter = pair._2
       res + (counter -> state)
     })
   }

  def findNextStateIndexes(dsg: DSG, state: S, stateToIntMap: Map[S, Int]): Set[Int] = {
    val curStIndx = stateToIntMap(state)
    dsg.edges.foldLeft(Set[Int]())((res, eg) => {
      eg match {
        case Edge(s1, edge, s2) => {
          if (curStIndx == stateToIntMap(s1))
            res + stateToIntMap(s2)
          else
            res
        }
        case _ => res
      }
    })
  }

  /**
   * for each dsg, we will have the graph representation 
   */
  def buildAdjListGraph(dsgs: List[DSG]): List[ scala.collection.mutable.Map[Int, Int]] ={
  //(List[Map[Int, Set[Int]]], Map[S, Int], Map[Int, S])= {
    val map: Map[S, Int] = genSToCounter(dsgs)
    val integerToStateMap = genCounterToSMap(map) 
    
    val res = dsgs.foldLeft(List[scala.collection.mutable.Map[Int, Int]]())((res, dsg) => {
      val nodes = dsg.nodes
      val curInitIndex = map(dsg.s0)
      val curNextIndexes =  findNextStateIndexes(dsg, dsg.s0, map)
     
      val marked = scala.collection.mutable.Map[Int, Boolean] ()
      val edgeTo = scala.collection.mutable.Map[Int, Int] ()
      
      initInformation(marked, edgeTo, curNextIndexes) 
      
      // get the adjcent representtaion for the graph
      val oneGraphAdjReprentation = 
        nodes.foldLeft(Map[Int, Set[Int]]())((resMap, node) => {
      val curIndx = map(node)
      val nextStateIndexes = findNextStateIndexes(dsg, node, map) 
      resMap + (curIndx -> nextStateIndexes)
    })
    
    // dfs the paths starting from the init state of the current dsg
    dfs(dsg, oneGraphAdjReprentation, curInitIndex, marked, edgeTo, map, integerToStateMap)
    
    edgeTo :: res
    }) 
    res
      //  List()
  }
  
  private def initInformation(marked: scala.collection.mutable.Map[Int, Boolean], edgeTo:scala.collection.mutable.Map[Int, Int], nextIndexes: Set[Int]){
    nextIndexes.foreach {
      case index => {
        marked += (index -> false)
        edgeTo += (index -> -1)
      }
    }
  }
  
//  /**
//   * @stateIndex: The starting Index, we only need the initial state here
//   */
//  def getPathsByDFS(dsg: DSG, stateIndex: Int, map: Map[S, Int]) : scala.collection.mutable.Map[Int, Int]= {
//    val arrBuff = ArrayBuffer[Boolean]()
//    val initStateIndex = map(dsg.s0)
//    // the global length, will get the maximum
//    val maxSize = map.values.toList.sortWith(_ > _).head
//    val marked = scala.collection.mutable.Map[Int, Boolean] ()
//    val edgeTo = scala.collection.mutable.Map[Int, Int] ()
//    
//    dfs(dsg, initStateIndex, marked, edgeTo) 
//    edgeTo
//  }
  
  /**
   * 
   */
  
  private def dfs(dsg: DSG, adjGraphMap: Map[Int, Set[Int]], 
      curIndex: Int, 
      marked: scala.collection.mutable.Map[Int, Boolean] , 
      edgeTo: scala.collection.mutable.Map[Int, Int], map: Map[S, Int], indexToSMap: Map[Int, S]) {
      
    // during recursion, make sure the edges add first
    initInformation(marked, edgeTo, findNextStateIndexes(dsg, indexToSMap(curIndex), map))
     marked += (curIndex -> true) 
      val nextStateIndexes = adjGraphMap(curIndex)
      nextStateIndexes.foreach {
        case nextIndx => {
          // you'd better ensure that it is inserted, it is initlized to contain!
          if(marked.contains(nextIndx) && marked(nextIndx)) {
            edgeTo += (nextIndx -> curIndex)
            dfs(dsg, adjGraphMap,nextIndx, marked, edgeTo, map, indexToSMap)
          }
          //what if there is no sucj index?
        }
      }
      
  }
  
  
   /**
   * Prints DSG according to the passed parameters
   */
  def prettyPrintDSGs(dsgs: List[DSG], graphParentFolerPath: String, opts: AIOptions): String = {
 
    val map: Map[S, Int] = genSToCounter(dsgs) 
    val buffer = new StringBuffer
    buffer.append("digraph BST {\n \n ")
 
     var list: List[String] = List() 
     dsgs.foreach((dsg) => {
       list = prettyPrintOneDSG(dsg , graphParentFolerPath , map ,opts)  :: list
     }) 
    buffer.append(list.distinct.mkString("")) 
    buffer.append("}\n") 
    buffer.toString
  }
  
  private def buildHtmlPath(state: ControlState, map: Map[ControlState, Int], graphParentFolder: String) : String ={
   import java.io._
    graphParentFolder + File.separator + map(state) +".html"
  }
  
  
  def writeStateToHtmlfile(state: ControlState, map: Map[ControlState, Int], htmlPath: String) {
    import java.io._
   // val htmlPath = buildHtmlPath(state, map, graphParentFolder)//graphParentFolder + File.separator + map(state) +".html"
    val file = new File(htmlPath)
    if (!file.exists()) {
      file.createNewFile()
    }
    val writer = new FileWriter(file)
     writer.write(genPrettyStateToHtml(state, map))
    writer.close()
  }
 
}
