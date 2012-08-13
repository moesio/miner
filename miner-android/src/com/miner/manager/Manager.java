package com.miner.manager;

import java.util.ArrayList;

import android.content.Context;
import android.location.Location;

import com.google.android.maps.GeoPoint;
import com.miner.domain.Miner;
import com.miner.main.R;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class Manager {
	
	public ArrayList<Miner> getMiners(Context context, Location location){
		ArrayList<Miner> miners = new ArrayList<Miner>();
		
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3746160,-38526263), context.getResources().getDrawable(R.drawable.armed), 0));
		miners.add(new Miner("Paulo", "Rubi", "Estou confiante", new GeoPoint(-3746540,-38527331), context.getResources().getDrawable(R.drawable.blue), 0));
		miners.add(new Miner("Eduardo", "Ouro", "Estou confiante", new GeoPoint(-3747172,-38526676), context.getResources().getDrawable(R.drawable.spider), 0));
		
		miners.add(new Miner("Caio", "Prata", "Estou confiante", new GeoPoint(-3745192,-38524472), context.getResources().getDrawable(R.drawable.robot), 0));
		miners.add(new Miner("Rui", "Bronze", "Estou confiante", new GeoPoint(-3745475,-38525764), context.getResources().getDrawable(R.drawable.atomic), 0));
		miners.add(new Miner("Thiago", "Ouro", "Estou confiante", new GeoPoint(-3746963,-38525078), context.getResources().getDrawable(R.drawable.fly), 0));
		
		miners.add(new Miner("Solon", "Prata", "Estou confiante", new GeoPoint(-3741509,-38527915), context.getResources().getDrawable(R.drawable.iron), 0));
		miners.add(new Miner("Alex", "Aço", "Estou confiante", new GeoPoint(-3742751,-38528452), context.getResources().getDrawable(R.drawable.little), 0));
		miners.add(new Miner("Aureo", "Ferro", "Estou confiante", new GeoPoint(-3741316,-38522508), context.getResources().getDrawable(R.drawable.crawler), 0));
		
		miners.add(new Miner("Daniel", "Magma", "Estou confiante", new GeoPoint(-3745491,-38528645), context.getResources().getDrawable(R.drawable.dog), 0));
		miners.add(new Miner("Moésio", "Diamante", "Estou confiante", new GeoPoint(-3747161,-38529353), context.getResources().getDrawable(R.drawable.panaroid), 0));
		miners.add(new Miner("Max", "Diamante", "Estou confiante", new GeoPoint(-3744506,-38521628), context.getResources().getDrawable(R.drawable.happy), 0));
		
		miners.add(new Miner("Barreto", "Diamante", "Estou confiante", new GeoPoint(-374289,-38525975), context.getResources().getDrawable(R.drawable.panaroif), 0));
		miners.add(new Miner("Bruno", "Diamante", "Estou confiante", new GeoPoint(-3743072,-38528099), context.getResources().getDrawable(R.drawable.sad), 0));
		miners.add(new Miner("Rafael", "Diamante", "Estou confiante", new GeoPoint(-3744078,-38528014), context.getResources().getDrawable(R.drawable.dancing), 0));
		
/*		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3736016,-38471986), context.getResources().getDrawable(R.drawable.panaroid), false));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3737537,-38469400), context.getResources().getDrawable(R.drawable.armed), false));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3732955,-38467855), context.getResources().getDrawable(R.drawable.spider), false));
		
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3735192,-38466386), context.getResources().getDrawable(R.drawable.little), false));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3737237,-38466311), context.getResources().getDrawable(R.drawable.little), false));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3734475,-38465881), context.getResources().getDrawable(R.drawable.blue), false));
		
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3733308,-38472812), context.getResources().getDrawable(R.drawable.panaroid), false));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3734635,-38475173), context.getResources().getDrawable(R.drawable.blue), false));
		miners.add(new Miner("Marcus", "Diamante", "Estou confiante", new GeoPoint(-3728704,-38465946), context.getResources().getDrawable(R.drawable.robot), false));*/
		
        return miners;
	}

}
