package com.ecommerce;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="products", schema="ecommerce")
public class Products {
	    @Id
        private int ID;
        private String name;
        private String category;
        private int stock_quantity;
        
        public Products() {
                
        }
        public Products( String name, String category, int stock_quantity) {
                this.name = name;
                this.category = category;
                this.stock_quantity = stock_quantity;
        }
	
        
		public int getId() {
			return ID;
		}
		public void setId(int id) {
			this.ID = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public int getStock_quantity() {
			return stock_quantity;
		}
		public void setStock_quantity(int stock_quantity) {
			this.stock_quantity = stock_quantity;
		}
		
		public String toString() {
			return "Name: " + name + " Category: " + category + " Stock Quantity: " + stock_quantity;
			
		}
        
        
        
}


