package com.myrev.rp.jobs;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import com.myrev.rp.dm.Edge;
import com.myrev.rp.dm.Journey;
import com.myrev.rp.dm.Route;
import com.myrev.rp.engine.INode;
import com.myrev.rp.engine.IPath;

public class EnquiryOutput 
{
	public EnquiryOutput()
	{
		
	}
	
	
	protected String getJourneyOutput(Journey journey, boolean htmlPage)
	{
		String output = StringUtils.EMPTY;
		List<Route> routeList = journey.getRouteList();
		
		for (int i = 0; i < routeList.size(); i++)
		{
			Route route = routeList.get(i);
			output += htmlPage ? getRouteOutputForWeb(route) :  getRouteOutput(route);
		}
		return output;
	}
	
	
	// TODO refactor
	private String getRouteOutput(Route route)
	{
		String output = "";
		output += "\nStart  " + route.getStartNodeName() + "";
		output += "\nEnd    " + route.getDestNodeName() + "\n";
		
		List<Edge> legList = route.getSummaryLegs();
		
		for (int i = 0; i < legList.size(); i++)
		{
			Edge leg = legList.get(i);
			output += getLegOutput(leg) + "\n";
		}
		output += "Changes = " + route.getNumberChanges() + "\n";
		output += "Total stops = " + route.getTotalWeighting() + "\n\n";
		
		return output;
	}
	
	
	
	// TODO refactor
	private String getRouteOutputForWeb(Route route)
	{
		String output = "";
		output += "<br>Start  " + route.getStartNodeName() + "";
		output += "<br>End    " + route.getDestNodeName() + "<br>";
		
		List<Edge> legList = route.getSummaryLegs();
		
		for (int i = 0; i < legList.size(); i++)
		{
			Edge leg = legList.get(i);
			output += getLegOutput(leg) + "<br>";
		}
		output += "Changes = " + route.getNumberChanges() + "<br>";
		output += "Total stops = " + route.getTotalWeighting() + "<br><br>";
		
		return output;
	}
	
	
	
	// TODO refactor
	private String getLegOutput(Edge leg)
	{
		INode start = leg.getStart();
		INode dest = leg.getDest();
		int weighting = leg.getWeighting();
		IPath line = leg.getLine();
		if (weighting > 1)
		{
			return "From " + start.getName() + " take the " + line.getPathName() +
	        " to " + dest.getName() + " for " + weighting + " stops.";
		}
		else // grammar is singular
		{
			return "From " + start.getName() + " take the " + line.getPathName() +
	        " to " + dest.getName() + " for " + weighting + " stop.";
		}
		
	}
	
}
