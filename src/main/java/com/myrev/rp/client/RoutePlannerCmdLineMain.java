package com.myrev.rp.client;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.myrev.rp.dm.Journey;
import com.myrev.rp.engine.IRouteMap;
import com.myrev.rp.engine.RouteMapReader;
import com.myrev.rp.ex.DuplicateStationException;
import com.myrev.rp.ex.InvalidNetworkException;
import com.myrev.rp.ex.InvalidStationException;
import com.myrev.rp.ex.NoJourneyFoundException;
import com.myrev.rp.jobs.IRoutePlanner;
import com.myrev.rp.jobs.RoutePlanner;


public class RoutePlannerCmdLineMain {

	public RoutePlannerCmdLineMain() {
		
	}

	public static void main(String[] args) {
		RoutePlannerCmdLineMain mainApp = new RoutePlannerCmdLineMain();
		
		IRouteMap mapData;
		try {
			mapData = mainApp.loadSystemData();
			IRoutePlanner planner = new RoutePlanner(mapData); 
			String[] routeDetails = mainApp.getRouteEnquiryDetails();
			Journey journey = planner.lookupJourney(routeDetails[0], routeDetails[1]);
			String journeyDisplay = planner.getJourneyString(journey);
			System.out.println(journeyDisplay);
		} catch(FileNotFoundException e) {
			System.out.println("File not found");
		} catch(IOException e) {
			System.out.println("IOException ");
		} catch(InvalidStationException e) {
			System.out.println("Invalid Station");
		} catch(InvalidNetworkException e) {
			System.out.println("Invalid Network");
		} catch(NoJourneyFoundException e) {
			System.out.println("No Journey Found");
		} catch (DuplicateStationException e) {
			System.out.println("Duplicate Station entered - presumably start and destination are the same");
		}
	}    // e.printStackTrace();
	
	
	
	public String[] getRouteEnquiryDetails() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Welcome. \nPlease enter a starting station: ");
		String start = br.readLine();
		
		System.out.println("Now enter a destination station: ");
		String destination = br.readLine();
		
		// obviously would normally apply checking here
		
		return new String[] {start, destination};
	}
	
	
	
	public IRouteMap loadSystemData() throws IOException, FileNotFoundException, InvalidNetworkException {
		RouteMapReader reader = new RouteMapReader();
		return reader.buildIRouteMap("LondonTube.xml");
	}

	

}
