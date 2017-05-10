package com.sb205.missing_pieces.Config;

/*
 * User: Sboy205
 * Date: 5/9/2017
 *
 * The Startup classes for this example are called during startup, in the following order:
 *  preInitCommon
 *  preInitClientOnly
 *  initCommon
 *  initClientOnly
 *  postInitCommon
 *  postInitClientOnly
 */

public class StartupClientOnly {
	public static void preInitClientOnly() 
	{
    MpConfiguration.clientInit();  // used to set up an event handler for the GUI so that the altered values are
                                    //  saved back to disk.
	}
	
	public static void initClientOnly() 
	{
	}
	
	public static void postInitClientOnly() 
	{
	}
	
}
