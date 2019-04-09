package com.myrev.rp.engine;
//import com.fdm.routePlanner.businessObject.*;
//import com.fdm.routePlanner.exception.*;
import java.util.LinkedList;
import com.myrev.rp.ex.NoJourneyFoundException;


public interface IRouteEnquiry
{
	/**
     * Infinity value for distances.
     */
    
	//public void printPredecessors();
	public void execute(INode start, INode destination);
    public LinkedList getPredecessorList(INode iNode) throws NoJourneyFoundException;
    public int getShortestDistance(INode INode);
     
}
