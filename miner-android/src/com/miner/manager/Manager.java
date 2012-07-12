package com.miner.manager;

import java.util.ArrayList;

import android.location.Location;

import com.google.android.maps.GeoPoint;
import com.miner.main.Miner;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class Manager {
	
	public ArrayList<Miner> getMiners(Location location){
		ArrayList<Miner> miners = new ArrayList<Miner>();
		
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3746160,-38526263)));
		miners.add(new Miner("Paulo", "Rubi", "Estou confiante", new GeoPoint(-3746540,-38527331)));
		miners.add(new Miner("Eduardo", "Ouro", "Estou confiante", new GeoPoint(-3747172,-38526676)));
		
		miners.add(new Miner("Caio", "Prata", "Estou confiante", new GeoPoint(-3745192,-38524472)));
		miners.add(new Miner("Rui", "Bronze", "Estou confiante", new GeoPoint(-3745475,-38525764)));
		miners.add(new Miner("Thiago", "Ouro", "Estou confiante", new GeoPoint(-3746963,-38525078)));
		
		miners.add(new Miner("Solon", "Prata", "Estou confiante", new GeoPoint(-3741509,-38527915)));
		miners.add(new Miner("Alex", "Aço", "Estou confiante", new GeoPoint(-3742751,-38528452)));
		miners.add(new Miner("Aureo", "Ferro", "Estou confiante", new GeoPoint(-3741316,-38522508)));
		
		miners.add(new Miner("Daniel", "Magma", "Estou confiante", new GeoPoint(-3745491,-38528645)));
		miners.add(new Miner("Moésio", "Diamante", "Estou confiante", new GeoPoint(-3747161,-38529353)));
		miners.add(new Miner("Max", "Diamante", "Estou confiante", new GeoPoint(-3744506,-38521628)));
		
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3734732,-38468821)));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3733137,-38470441)));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3733565,-38467351)));
		
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3736016,-38471986)));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3737537,-38469400)));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3732955,-38467855)));
		
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3735192,-38466386)));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3737237,-38466311)));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3734475,-38465881)));
		
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3733308,-38472812)));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3734635,-38475173)));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3728704,-38465946)));
		
        return miners;
	}

}
