package com.hbm.render.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hbm.items.ModItems;
import com.hbm.items.weapon.ItemMissile.PartType;
import com.hbm.main.ResourceManager;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;

public class MissilePart {
	
	public static HashMap<Integer, MissilePart> parts = new HashMap<Integer, MissilePart>();

	public Item part;
	public PartType type;
	public double height;
	public double guiheight;
	public IModelCustom model;
	public ResourceLocation texture;
	
	private MissilePart(Item item, PartType type, double height, double guiheight, IModelCustom model, ResourceLocation texture) {
		this.part = item;
		this.type = type;
		this.height = height;
		this.guiheight = guiheight;
		this.model = model;
		this.texture = texture;
	}
	
	public static void registerAllParts() {
		
		parts.clear();

		MissilePart.registerPart(ModItems.mp_thruster_10_kerosene, PartType.THRUSTER, 1, 1, ResourceManager.mp_t_10_kerosene, ResourceManager.mp_t_10_kerosene_tex);
		MissilePart.registerPart(ModItems.mp_thruster_10_solid, PartType.THRUSTER, 0.5, 1, ResourceManager.mp_t_10_solid, ResourceManager.mp_t_10_solid_tex);
		MissilePart.registerPart(ModItems.mp_thruster_10_xenon, PartType.THRUSTER, 0.5, 1, ResourceManager.mp_t_10_xenon, ResourceManager.mp_t_10_xenon_tex);
		//
		MissilePart.registerPart(ModItems.mp_thruster_15_kerosene, PartType.THRUSTER, 1.5, 1.5, ResourceManager.mp_t_15_kerosene, ResourceManager.mp_t_15_kerosene_tex);
		MissilePart.registerPart(ModItems.mp_thruster_15_kerosene_dual, PartType.THRUSTER, 1, 1.5, ResourceManager.mp_t_15_kerosene_dual, ResourceManager.mp_t_15_kerosene_dual_tex);
		MissilePart.registerPart(ModItems.mp_thruster_15_kerosene_triple, PartType.THRUSTER, 1, 1.5, ResourceManager.mp_t_15_kerosene_triple, ResourceManager.mp_t_15_kerosene_dual_tex);
		MissilePart.registerPart(ModItems.mp_thruster_15_solid, PartType.THRUSTER, 0.5, 1, ResourceManager.mp_t_15_solid, ResourceManager.mp_t_15_solid_tex);
		MissilePart.registerPart(ModItems.mp_thruster_15_solid_hexdecuple, PartType.THRUSTER, 0.5, 1, ResourceManager.mp_t_15_solid_hexdecuple, ResourceManager.mp_t_15_solid_hexdecuple_tex);
		MissilePart.registerPart(ModItems.mp_thruster_15_hydrogen, PartType.THRUSTER, 1.5, 1.5, ResourceManager.mp_t_15_kerosene, ResourceManager.mp_t_15_hydrogen_tex);
		MissilePart.registerPart(ModItems.mp_thruster_15_hydrogen_dual, PartType.THRUSTER, 1, 1.5, ResourceManager.mp_t_15_kerosene_dual, ResourceManager.mp_t_15_hydrogen_dual_tex);
		MissilePart.registerPart(ModItems.mp_thruster_15_balefire_short, PartType.THRUSTER, 2, 2, ResourceManager.mp_t_15_balefire_short, ResourceManager.mp_t_15_balefire_short_tex);
		MissilePart.registerPart(ModItems.mp_thruster_15_balefire, PartType.THRUSTER, 3, 2.5, ResourceManager.mp_t_15_balefire, ResourceManager.mp_t_15_balefire_tex);
		MissilePart.registerPart(ModItems.mp_thruster_15_balefire_large, PartType.THRUSTER, 3, 2.5, ResourceManager.mp_t_15_balefire_large, ResourceManager.universal);
		//
		MissilePart.registerPart(ModItems.mp_thruster_20_kerosene, PartType.THRUSTER, 2.25, 2, ResourceManager.mp_t_20, ResourceManager.universal);

		//////
		
		MissilePart.registerPart(ModItems.mp_stability_10_flat, PartType.FINS, 0, 2, ResourceManager.mp_s_10_flat, ResourceManager.mp_s_10_flat_tex);
		MissilePart.registerPart(ModItems.mp_stability_10_cruise, PartType.FINS, 0, 3, ResourceManager.mp_s_10_cruise, ResourceManager.mp_s_10_cruise_tex);
		//
		MissilePart.registerPart(ModItems.mp_stability_15_flat, PartType.FINS, 0, 3, ResourceManager.mp_s_15_flat, ResourceManager.mp_s_15_flat_tex);
		MissilePart.registerPart(ModItems.mp_stability_15_thin, PartType.FINS, 0, 3, ResourceManager.mp_s_15_thin, ResourceManager.mp_s_15_thin_tex);
		//
		MissilePart.registerPart(ModItems.mp_stability_20_flat, PartType.FINS, 0, 3, ResourceManager.mp_s_20, ResourceManager.universal);

		//////
		
		MissilePart.registerPart(ModItems.mp_fuselage_10_kerosene, PartType.FUSELAGE, 4, 3, ResourceManager.mp_f_10_kerosene, ResourceManager.mp_f_10_kerosene_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_kerosene_camo, PartType.FUSELAGE, 4, 3, ResourceManager.mp_f_10_kerosene, ResourceManager.mp_f_10_kerosene_camo_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_kerosene_desert, PartType.FUSELAGE, 4, 3, ResourceManager.mp_f_10_kerosene, ResourceManager.mp_f_10_kerosene_desert_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_kerosene_flames, PartType.FUSELAGE, 4, 3, ResourceManager.mp_f_10_kerosene, ResourceManager.mp_f_10_kerosene_flames_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_kerosene_sleek, PartType.FUSELAGE, 4, 3, ResourceManager.mp_f_10_kerosene, ResourceManager.mp_f_10_kerosene_sleek_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_kerosene_metal, PartType.FUSELAGE, 4, 3, ResourceManager.mp_f_10_kerosene, ResourceManager.mp_f_10_kerosene_metal_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_solid, PartType.FUSELAGE, 4, 3, ResourceManager.mp_f_10_kerosene, ResourceManager.mp_f_10_solid_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_solid_flames, PartType.FUSELAGE, 4, 3, ResourceManager.mp_f_10_kerosene, ResourceManager.mp_f_10_solid_flames_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_solid_sleek, PartType.FUSELAGE, 4, 3, ResourceManager.mp_f_10_kerosene, ResourceManager.mp_f_10_solid_sleek_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_xenon, PartType.FUSELAGE, 4, 3, ResourceManager.mp_f_10_kerosene, ResourceManager.mp_f_10_xenon_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_long_kerosene, PartType.FUSELAGE, 7, 5, ResourceManager.mp_f_10_long_kerosene, ResourceManager.mp_f_10_long_kerosene_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_long_kerosene_camo, PartType.FUSELAGE, 7, 5, ResourceManager.mp_f_10_long_kerosene, ResourceManager.mp_f_10_long_kerosene_camo_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_long_kerosene_desert, PartType.FUSELAGE, 7, 5, ResourceManager.mp_f_10_long_kerosene, ResourceManager.mp_f_10_long_kerosene_desert_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_long_kerosene_flames, PartType.FUSELAGE, 7, 5, ResourceManager.mp_f_10_long_kerosene, ResourceManager.mp_f_10_long_kerosene_flames_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_long_kerosene_sleek, PartType.FUSELAGE, 7, 5, ResourceManager.mp_f_10_long_kerosene, ResourceManager.mp_f_10_long_kerosene_sleek_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_long_kerosene_metal, PartType.FUSELAGE, 7, 5, ResourceManager.mp_f_10_long_kerosene, ResourceManager.mp_f_10_long_kerosene_metal_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_long_solid, PartType.FUSELAGE, 7, 5, ResourceManager.mp_f_10_long_kerosene, ResourceManager.mp_f_10_long_solid_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_long_solid_flames, PartType.FUSELAGE, 7, 5, ResourceManager.mp_f_10_long_kerosene, ResourceManager.mp_f_10_long_solid_flames_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_long_solid_sleek, PartType.FUSELAGE, 7, 5, ResourceManager.mp_f_10_long_kerosene, ResourceManager.mp_f_10_long_solid_sleek_tex);
		//
		MissilePart.registerPart(ModItems.mp_fuselage_10_15_kerosene, PartType.FUSELAGE, 9, 5.5, ResourceManager.mp_f_10_15_kerosene, ResourceManager.mp_f_10_15_kerosene_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_15_solid, PartType.FUSELAGE, 9, 5.5, ResourceManager.mp_f_10_15_kerosene, ResourceManager.mp_f_10_15_solid_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_15_hydrogen, PartType.FUSELAGE, 9, 5.5, ResourceManager.mp_f_10_15_kerosene, ResourceManager.mp_f_10_15_hydrogen_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_10_15_balefire, PartType.FUSELAGE, 9, 5.5, ResourceManager.mp_f_10_15_kerosene, ResourceManager.mp_f_10_15_balefire_tex);
		//
		MissilePart.registerPart(ModItems.mp_fuselage_15_kerosene, PartType.FUSELAGE, 10, 6, ResourceManager.mp_f_15_kerosene, ResourceManager.mp_f_15_kerosene_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_15_kerosene_camo, PartType.FUSELAGE, 10, 6, ResourceManager.mp_f_15_kerosene, ResourceManager.mp_f_15_kerosene_camo_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_15_kerosene_desert, PartType.FUSELAGE, 10, 6, ResourceManager.mp_f_15_kerosene, ResourceManager.mp_f_15_kerosene_desert_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_15_kerosene_metal, PartType.FUSELAGE, 10, 6, ResourceManager.mp_f_15_kerosene, ResourceManager.mp_f_15_kerosene_metal_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_15_kerosene_decorated, PartType.FUSELAGE, 10, 6, ResourceManager.mp_f_15_kerosene, ResourceManager.mp_f_15_kerosene_decorated_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_15_solid, PartType.FUSELAGE, 10, 6, ResourceManager.mp_f_15_kerosene, ResourceManager.mp_f_15_solid_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_15_solid_soviet_glory, PartType.FUSELAGE, 10, 6, ResourceManager.mp_f_15_kerosene, ResourceManager.mp_f_15_solid_soviet_glory_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_15_solid_soviet_stank, PartType.FUSELAGE, 10, 6, ResourceManager.mp_f_15_kerosene, ResourceManager.mp_f_15_solid_soviet_stank_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_15_hydrogen, PartType.FUSELAGE, 10, 6, ResourceManager.mp_f_15_hydrogen, ResourceManager.mp_f_15_hydrogen_tex);
		MissilePart.registerPart(ModItems.mp_fuselage_15_balefire, PartType.FUSELAGE, 10, 6, ResourceManager.mp_f_15_hydrogen, ResourceManager.mp_f_15_balefire_tex);
		//
		MissilePart.registerPart(ModItems.mp_fuselage_20_kerosene, PartType.FUSELAGE, 10, 8, ResourceManager.mp_f_20, ResourceManager.universal);

		//////
		
		MissilePart.registerPart(ModItems.mp_warhead_10_he, PartType.WARHEAD, 2, 1.5, ResourceManager.mp_w_10_he, ResourceManager.mp_w_10_he_tex);
		MissilePart.registerPart(ModItems.mp_warhead_10_incendiary, PartType.WARHEAD, 2.5, 2, ResourceManager.mp_w_10_incendiary, ResourceManager.mp_w_10_incendiary_tex);
		MissilePart.registerPart(ModItems.mp_warhead_10_buster, PartType.WARHEAD, 0.5, 1, ResourceManager.mp_w_10_buster, ResourceManager.mp_w_10_buster_tex);
		MissilePart.registerPart(ModItems.mp_warhead_10_nuclear, PartType.WARHEAD, 2, 1.5, ResourceManager.mp_w_10_nuclear, ResourceManager.mp_w_10_nuclear_tex);
		MissilePart.registerPart(ModItems.mp_warhead_10_nuclear_large, PartType.WARHEAD, 2.5, 1.5, ResourceManager.mp_w_10_nuclear_large, ResourceManager.mp_w_10_nuclear_large_tex);
		//
		MissilePart.registerPart(ModItems.mp_warhead_15_he, PartType.WARHEAD, 2, 1.5, ResourceManager.mp_w_15_he, ResourceManager.mp_w_15_he_tex);
		MissilePart.registerPart(ModItems.mp_warhead_15_incendiary, PartType.WARHEAD, 2, 1.5, ResourceManager.mp_w_15_incendiary, ResourceManager.mp_w_15_incendiary_tex);
		MissilePart.registerPart(ModItems.mp_warhead_15_nuclear, PartType.WARHEAD, 3.5, 2, ResourceManager.mp_w_15_nuclear, ResourceManager.mp_w_15_nuclear_tex);
		//
		MissilePart.registerPart(ModItems.mp_warhead_20_he, PartType.WARHEAD, 3, 2.25, ResourceManager.mp_w_20, ResourceManager.universal);
		
	}
	
	public static void registerPart(Item item, PartType type, double height, double guiheight, IModelCustom model, ResourceLocation texture) {
		
		MissilePart part = new MissilePart(item, type, height, guiheight, model, texture);
		parts.put(item.hashCode(), part);
	}
	
	public static MissilePart getPart(Item item) {
		
		if(item == null)
			return null;
		
		return parts.get(item.hashCode());
	}

}