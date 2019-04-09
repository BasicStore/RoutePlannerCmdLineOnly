package com.myrev.rp.engine;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myrev.rp.jobs.DataLoader;
import com.myrev.rp.lu.dm.Line;
import com.myrev.rp.lu.dm.UndergroundMap;

//import com.fdm.routeplanner.data.LineDataReader;
//import com.fdm.routeplanner.data.exception.InvalidNetWorkException;
//import com.fdm.seminar.routeplanner.jobs.DataLoader;
//import com.fdm.seminar.routeplanner.london_ug.UndergroundMap;




public class RouteMapReader 
{
	
	
	public RouteMapReader() 
	{
		
		
		
	}

	
	
//	public IRouteMap buildIRouteMap(String relativeLibraryFolder, String filename) throws FileNotFoundException, 
//	                                                                 InvalidNetWorkException, IOException
//	{
//		String path = relativeLibraryFolder + filename + "";
//		File file = new File(path);
//		FactoryINode factory = new FactoryINode();
//		IRouteMap iRouteMap = new UndergroundMap();
//		LineDataReader reader = new LineDataReader();
//		Map<String,String> xmlFile = reader.getNetworkData(file);
//		DataLoader loader = new DataLoader(xmlFile,iRouteMap,factory);
//		loader.loadIRouteMap();
//		return iRouteMap;
//	}
	
	
	
	
	public IRouteMap buildIRouteMap(String path) throws FileNotFoundException, IOException
    {                                                          // InvalidNetWorkException,
		File file = new File(path);
		FactoryINode factory = new FactoryINode();
		IRouteMap iRouteMap = new UndergroundMap();
		
		//LineDataReader reader = new LineDataReader();
		
		
		Map<String,String> xmlFile = dummyGetLondonUndergroundMap();//reader.getNetworkData(file);
		DataLoader loader = new DataLoader(xmlFile,iRouteMap,factory);
		loader.loadIRouteMap();
		return iRouteMap;
    }	

	
	// new Line("Piccadilly", "dark blue")     new Line("", "")
	
	
	/*
	 UndergroundMap implements IRouteMap
{
	private List<IPath> lineList;
	private Map stations;
	
	
	public UndergroundMap()
	 */
	
	
	
	
	// TODO TMP SOLUTION!!!1
	private Map<String,String> dummyGetLondonUndergroundMap() {
		
		List<IPath> lineList = Arrays.asList(new Line("Piccadilly", "dark blue"),
											new Line("Victoria", "light blue"),
											new Line("District", "green"));
		Map<String,String> ugMap = new HashMap<String,String>();
		
		
		
		
		
		
		return null;
	}
	
	
	
	
//	// TODO 
//	public List<String> getListAllStations(IRouteMap iRouteMap)
//	{
//		LinkedList stationList = new LinkedList();
//		Map<String,INode> stations = iRouteMap.getINodes(); 
//		Set<String> keySet = stations.keySet();
//		for (String key : keySet)
//		{
//		    String value = ((INode)stations.get(key)).getName();
//		    stationList.add(value);	
//		} 
//		Collections.sort(stationList);
//		return stationList;
//	}
	
	
	
	
	
}
