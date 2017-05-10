package com.sb205.missing_pieces.Config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.sb205.missing_pieces.MissingPieces;

public class MpGuiFactory implements IModGuiFactory 
{
	//this class is accessed when Forge needs a GUI made relating to your mod (e.g. config GUI)
	
	@Override
	public void initialize(Minecraft minecraftInstance) 
	{
		//needed to implement IModGuiFactory but doesn't need to do anything
		// for the configuration gui
	}
	
	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() 
	{
		return MissingPiecesConfigGui.class; //tells Forge which class represents our main GUI screen
	}
	
	//The following two functions are needed for implementation only, the config gui does not require them
	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() 
	{
		return null;
	}
	
	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) 
	{
		return null;
	}
	
	//This class inherits from GuiConfig, a specialized GuiScreen designed to display your
	// configuration categories
	public static class MissingPiecesConfigGui extends GuiConfig 
	{
		public MissingPiecesConfigGui(GuiScreen parentScreen) 
		{
			//I18n function basically "translates" or localizes the given key using the appropriate .lang file
			super(parentScreen, getConfigElements(), MissingPieces.MODID,
            false, false, I18n.format("gui.configuration.main_title"));
		}
		
		private static List<IConfigElement> getConfigElements() 
		{
			List<IConfigElement> list = new ArrayList<IConfigElement>();
			//Add the two buttons that will go to each config category edit screen
			list.add(new DummyCategoryElement("wedgesCfg", 			"gui.configuration.wedges", 		CategoryEntryWedges.class));
			list.add(new DummyCategoryElement("pillarsCfg", 		"gui.configuration.pillars", 		CategoryEntryPillars.class));
			list.add(new DummyCategoryElement("LampsCfg", 			"gui.configuration.lamps", 			CategoryEntryLamps.class));
			list.add(new DummyCategoryElement("CandelabrasCfg", 	"gui.configuration.candelabras", 	CategoryEntryCandelabras.class));
			list.add(new DummyCategoryElement("tablesCfg", 			"gui.configuration.tables", 		CategoryEntryTables.class));
			list.add(new DummyCategoryElement("ChairsCfg", 			"gui.configuration.chairs", 		CategoryEntryChairs.class));
			list.add(new DummyCategoryElement("SlabsCfg", 			"gui.configuration.slabs", 			CategoryEntrySlabs.class));
			list.add(new DummyCategoryElement("ShelvesCfg", 		"gui.configuration.shelves", 		CategoryEntryShelves.class));
			list.add(new DummyCategoryElement("BaseLampsCfg", 		"gui.configuration.baselamps", 		CategoryEntryBaseLamps.class));
			list.add(new DummyCategoryElement("BaseCandelabrasCfg", "gui.configuration.basecandelabras", CategoryEntryBaseCandelabras.class));
			list.add(new DummyCategoryElement("MiscCfg", 			"gui.configuration.misc", 			CategoryEntryMisc.class));
			list.add(new DummyCategoryElement("naturaWedgesCfg", 	"gui.configuration.naturawedges", 		CategoryEntryNaturaWedges.class));
			list.add(new DummyCategoryElement("naturaPillarsCfg", 	"gui.configuration.naturapillars", 		CategoryEntryNaturaPillars.class));
			list.add(new DummyCategoryElement("naturaLampsCfg", 	"gui.configuration.naturalamps", 		CategoryEntryNaturaLamps.class));
			list.add(new DummyCategoryElement("naturaCandelabrasCfg","gui.configuration.naturacandelabras", CategoryEntryNaturaCandelabras.class));
			list.add(new DummyCategoryElement("naturaTablesCfg", 	"gui.configuration.naturatables", 		CategoryEntryNaturaTables.class));
			list.add(new DummyCategoryElement("naturaChairsCfg", 	"gui.configuration.naturachairs", 		CategoryEntryNaturaChairs.class));
			list.add(new DummyCategoryElement("naturaShelvesCfg", 	"gui.configuration.naturashelves", 		CategoryEntryNaturaShelves.class));
			return list;
		}
		
		public static class CategoryEntryWedges extends CategoryEntry
		{
			public CategoryEntryWedges(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_WEDGES));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.wedges");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_WEDGES,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}

		public static class CategoryEntryShelves extends CategoryEntry
		{
			public CategoryEntryShelves(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_SHELVES));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.shelves");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_SHELVES,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}

		public static class CategoryEntryPillars extends CategoryEntry
		{
			public CategoryEntryPillars(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}
			
			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

        Configuration configuration = MpConfiguration.getConfig();
        ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_PILLARS));
        List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
		String windowTitle = I18n.format("gui.configuration.pillars");

        return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
                              this.owningScreen.modID,
                              MpConfiguration.CATEGORY_NAME_PILLARS,
                              this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                              this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                              windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
		
		public static class CategoryEntryChairs extends CategoryEntry
		{
			public CategoryEntryChairs(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_CHAIRS));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.chairs");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_CHAIRS,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
		public static class CategoryEntryTables extends CategoryEntry
		{
			public CategoryEntryTables(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}
			
			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

        Configuration configuration = MpConfiguration.getConfig();
        ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_TABLES));
        List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
		String windowTitle = I18n.format("gui.configuration.tables");

        return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
                              this.owningScreen.modID,
                              MpConfiguration.CATEGORY_NAME_TABLES,
                              this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                              this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                              windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
		public static class CategoryEntryLamps extends CategoryEntry
		{
			public CategoryEntryLamps(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}
			
			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

        Configuration configuration = MpConfiguration.getConfig();
        ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_LAMPS));
        List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
		String windowTitle = I18n.format("gui.configuration.lamps");

        return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
                              this.owningScreen.modID,
                              MpConfiguration.CATEGORY_NAME_LAMPS,
                              this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                              this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                              windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
		public static class CategoryEntryCandelabras extends CategoryEntry
		{
			public CategoryEntryCandelabras(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_CANDELABRAS));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.candelabras");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_CANDELABRAS,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}		
		
		public static class CategoryEntryNaturaWedges extends CategoryEntry
		{
			public CategoryEntryNaturaWedges(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_NATURA_WEDGES));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.naturawedges");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_NATURA_WEDGES,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}

		public static class CategoryEntryNaturaShelves extends CategoryEntry
		{
			public CategoryEntryNaturaShelves(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_NATURA_SHELVES));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.naturashelves");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_NATURA_SHELVES,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}

		public static class CategoryEntryNaturaPillars extends CategoryEntry
		{
			public CategoryEntryNaturaPillars(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}
			
			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

        Configuration configuration = MpConfiguration.getConfig();
        ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_NATURA_PILLARS));
        List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
		String windowTitle = I18n.format("gui.configuration.naturapillars");

        return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
                              this.owningScreen.modID,
                              MpConfiguration.CATEGORY_NAME_NATURA_PILLARS,
                              this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                              this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                              windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
		
		public static class CategoryEntryNaturaChairs extends CategoryEntry
		{
			public CategoryEntryNaturaChairs(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_NATURA_CHAIRS));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.naturachairs");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_NATURA_CHAIRS,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
		public static class CategoryEntryNaturaTables extends CategoryEntry
		{
			public CategoryEntryNaturaTables(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}
			
			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

        Configuration configuration = MpConfiguration.getConfig();
        ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_NATURA_TABLES));
        List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
		String windowTitle = I18n.format("gui.configuration.naturatables");

        return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
                              this.owningScreen.modID,
                              MpConfiguration.CATEGORY_NAME_NATURA_TABLES,
                              this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                              this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                              windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
		public static class CategoryEntryNaturaLamps extends CategoryEntry
		{
			public CategoryEntryNaturaLamps(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}
			
			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

        Configuration configuration = MpConfiguration.getConfig();
        ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_NATURA_LAMPS));
        List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
		String windowTitle = I18n.format("gui.configuration.naturalamps");

        return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
                              this.owningScreen.modID,
                              MpConfiguration.CATEGORY_NAME_NATURA_LAMPS,
                              this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                              this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                              windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
		public static class CategoryEntryNaturaCandelabras extends CategoryEntry
		{
			public CategoryEntryNaturaCandelabras(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_NATURA_CANDELABRAS));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.naturacandelabras");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_NATURA_CANDELABRAS,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}		

		public static class CategoryEntryBaseLamps extends CategoryEntry
		{
			public CategoryEntryBaseLamps(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_BASEM_LAMPS));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.baselamps");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_BASEM_LAMPS,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
		public static class CategoryEntryBaseCandelabras extends CategoryEntry
		{
			public CategoryEntryBaseCandelabras(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_BASEM_CANDELABRAS));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.basecandelabras");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_BASEM_CANDELABRAS,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}		
		public static class CategoryEntrySlabs extends CategoryEntry
		{
			public CategoryEntrySlabs(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_SLABS));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				System.out.println("Slab count: " + propertiesOnThisScreen.size() );

				String windowTitle = I18n.format("gui.configuration.slabs");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_SLABS,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
		public static class CategoryEntryMisc extends CategoryEntry
		{
			public CategoryEntryMisc(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}
			
			@Override
			protected GuiScreen buildChildScreen() 
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the config file for the category as
				// the title for the category config screen

				Configuration configuration = MpConfiguration.getConfig();
				ConfigElement cat_general = new ConfigElement(configuration.getCategory(MpConfiguration.CATEGORY_NAME_MISC));
				List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
				String windowTitle = I18n.format("gui.configuration.misc");

				return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
						this.owningScreen.modID,
						MpConfiguration.CATEGORY_NAME_MISC,
						this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
						this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
						windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}

	}
}
