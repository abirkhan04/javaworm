package com.javaworm.itemprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.javaworm.model.Furniture;

public class FurnitureItemProcessor implements ItemProcessor<Furniture, Furniture> {

	private static final Logger log = LoggerFactory.getLogger(FurnitureItemProcessor.class);

	@Override
	public Furniture process(final Furniture furniture) throws Exception {
		final String name = furniture.getName().toUpperCase();
		final String price = furniture.getPrice();

		final Furniture transformedFurniture = new Furniture(name, price);

		log.info("Converting (" + furniture + ") into (" + transformedFurniture + ")");

		return transformedFurniture;
	}

}
