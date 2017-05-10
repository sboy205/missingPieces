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
public class StartupCommon 
{
	public static void preInitCommon()
	{
    MpConfiguration.init();

    }
	
	public static void initCommon() 
	{
	}
	
	public static void postInitCommon() 
	{
	}

}
