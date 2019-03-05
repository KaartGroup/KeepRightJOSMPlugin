package com.kaartgroup.openqa;

import java.io.IOException;

import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.gui.preferences.PreferenceSetting;
import org.openstreetmap.josm.plugins.Plugin;
import org.openstreetmap.josm.plugins.PluginInformation;
import org.openstreetmap.josm.spi.preferences.Config;
import org.openstreetmap.josm.tools.Logging;

import com.kaartgroup.openqa.profiles.keepright.KeepRightPreferences;

/**
 *
 * @author Taylor Smock
 *
 */
public class OpenQA extends Plugin {
	public String CACHE_DIR;
	public static String PREF_FILETYPE = "openqa.filetype";

	public OpenQA(PluginInformation info) {
		super(info);
		try {
			CACHE_DIR = getPluginDirs().getCacheDirectory(true).getCanonicalPath();
		} catch (IOException e) {
			CACHE_DIR = "openqa";
			Logging.debug(e.getMessage());
		}
		MainApplication.getLayerManager().addLayerChangeListener(new OpenQALayerChangeListener(CACHE_DIR));
		if (Config.getPref().get(PREF_FILETYPE) == "") {
			Config.getPref().put(PREF_FILETYPE, "geojson");
		}
		OpenQALayerChangeListener.updateOpenQALayers(CACHE_DIR);
	}

	@Override
	public PreferenceSetting getPreferenceSetting() {
		PreferenceSetting keepRight = new KeepRightPreferences(CACHE_DIR);
		return keepRight;
	}
}
