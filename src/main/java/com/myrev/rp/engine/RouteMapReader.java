package com.myrev.rp.engine;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.myrev.rp.ex.InvalidNetworkException;
import com.myrev.rp.jobs.DataLoader;
import com.myrev.rp.jobs.LineDataReader;
import com.myrev.rp.lu.dm.UndergroundMap;


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
	
	
	
	
	public IRouteMap buildIRouteMap(String path) throws FileNotFoundException, InvalidNetworkException, IOException
    {                                                          
		File file = new File(path);
		FactoryINode factory = new FactoryINode();
		IRouteMap iRouteMap = new UndergroundMap();
		
		// TODO OFFENDING LINE
		LineDataReader reader = new LineDataReader();
		
		
		
		Map<String,String> xmlFile = reader.getNetworkData(file);
		
		
		
		DataLoader loader = new DataLoader(xmlFile,iRouteMap,factory);
		loader.loadIRouteMap();
		return iRouteMap;
    }	

	
	
	
	public List<String> getListAllStations(IRouteMap iRouteMap)
	{
		LinkedList stationList = new LinkedList();
		Map<String,INode> stations = iRouteMap.getINodes(); 
		Set<String> keySet = stations.keySet();
		for (String key : keySet)
		{
		    String value = ((INode)stations.get(key)).getName();
		    stationList.add(value);	
		} 
		Collections.sort(stationList);
		return stationList;
	}
	
	
	
	
	
}
