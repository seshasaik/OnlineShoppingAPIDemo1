package com.onlineShoping.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShoping.demo.entity.GoodsReceipt;
import com.onlineShoping.demo.entity.Inventory;
import com.onlineShoping.demo.entity.ProductStock;
import com.onlineShoping.demo.entity.PurchaseOrderItem;
import com.onlineShoping.demo.repository.InventoryRepository;
import com.onlineShoping.demo.util.ProductStatus;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	public InventoryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateProductQuantity() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addProductQuantity(GoodsReceipt goodsReceipt) {
		// TODO Auto-generated method stub
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		goodsReceipt.getGoodsReceiptItems().stream().forEach((item) -> {

			Inventory inventory = inventoryRepository.findByProduct(item.getProduct()).orElse(new Inventory());

			if (!Objects.isNull(inventory) && !Objects.isNull(inventory.getStock()) && inventory.getStock().size() > 0) {
				inventory.setStock(inventory.getStock().stream().map((stock) -> {
					long totalQty = item.getReceivedQty() + stock.getQuntity();
					stock.setQuntity(totalQty);
					stock.setMrp(item.getUnitPrice());
					return stock;
				}).collect(Collectors.toList()));
				

			} else {

				if (Objects.isNull(inventory))
					inventory = new Inventory();

				ProductStock stock = new ProductStock();
				stock.setMrp(item.getUnitPrice());
				stock.setQuntity(item.getReceivedQty());
				stock.setStatus(ProductStatus.ACTIVE);

				inventory.setStock(new ArrayList<>());
				inventory.getStock().add(stock);

			}
			
			inventory.setProduct(item.getProduct());
			inventoryList.add(inventory);

		});

		inventoryRepository.saveAll(inventoryList);
	}

	@Override
	public void getProductQuantity() {
		// TODO Auto-generated method stub
		inventoryRepository.findAll();
	}

	@Override
	public void getZeroBasedProductQuantity() {
		// TODO Auto-generated method stub

	}

}
