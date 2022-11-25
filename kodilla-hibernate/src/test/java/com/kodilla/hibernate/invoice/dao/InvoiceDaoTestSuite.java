package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@DisplayName("Invoice Dao Test Suite")
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    @Test
    void testInvoiceDaoSave(){
        //Given
        Product product = new Product("Logitech G Pro Mouse");
        Product product1 = new Product("Acer 27'");
        Product product2 = new Product("Tracer Mouse");

        Item item = new Item(BigDecimal.valueOf(400),5);
        Item item1 = new Item(BigDecimal.valueOf(380),3);
        Item item2 = new Item(BigDecimal.valueOf(330),5);
        Item item3 = new Item(BigDecimal.valueOf(500),2);
        Item item4 = new Item(BigDecimal.valueOf(700),10);
        Item item5 = new Item(BigDecimal.valueOf(50),1);

        Invoice invoice = new Invoice("Invoice #1/11/2022");

        product.getItems().add(item);
        product.getItems().add(item3);
        product1.getItems().add(item1);
        product1.getItems().add(item4);
        product2.getItems().add(item2);
        product2.getItems().add(item5);

        item.setProduct(product);
        item3.setProduct(product);
        item1.setProduct(product1);
        item4.setProduct(product1);
        item2.setProduct(product2);
        item5.setProduct(product2);

        invoice.getItems().add(item);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);
        invoice.getItems().add(item5);

        item.setInvoice(invoice);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);
        item5.setInvoice(invoice);
        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        //Then
        assertNotEquals(0,invoiceId);
        //CleanUp
        try {
            invoiceDao.deleteById(invoiceId);
        } catch (Exception e) {
            System.out.println("Couldn't delete records.");
        }
    }
}
