package com.br.pedro.backend;

import com.br.pedro.backend.domains.*;
import com.br.pedro.backend.enums.StatePayment;
import com.br.pedro.backend.enums.TypeClient;
import com.br.pedro.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    AdressRepository adressRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = Category.builder().name("Informática").build();
        Category cat2 = Category.builder().name("Escritório").build();

        Product p1 = Product.builder().name("Computador").price(2000.00).build();
        Product p2 = Product.builder().name("Impressora").price(300.00).build();
        Product p3 = Product.builder().name("Mouse").price(80.00).build();

        State s1 = State.builder().name("Minas Gerais").build();
        State s2 = State.builder().name("São Paulo").build();

        City c1 = City.builder().name("Belo Horizonte").state(s1).build();
        City c2 = City.builder().name("Uberlândia").state(s1).build();
        City c3 = City.builder().name("São Paulo").state(s2).build();
        City c4 = City.builder().name("Campinas").state(s2).build();

        Client cl1 = Client.builder().document("14789654102").typeClient(TypeClient.PESSOA_FISICA.getCode()).contactCell("3130448798").contactPhone("31998756589").name("Pedro Van Der Saar").email("pedro.saar@gmail.com").build();

        Adress ad1 = Adress.builder().adressCode("36587052").street("Rua das Oliveiras").neighborhood("Bairro das Oliveiras").number("32").client(cl1).city(c1).build();
        Adress ad2 = Adress.builder().adressCode("987235").street("Rua das Palmeiras").neighborhood("Bairro das Palmeiras").number("2123").client(cl1).city(c1).build();
        cl1.setAdressList(Arrays.asList(ad1, ad2));

        s1.setCities(Arrays.asList(c1, c2));
        s2.setCities(Arrays.asList(c3, c4));

        cat1.setProductList(Arrays.asList(p1,p2,p3));
        cat2.setProductList(Arrays.asList(p2));

        p1.setCategoryList(Arrays.asList(cat1));
        p2.setCategoryList(Arrays.asList(cat1, cat2));
        p3.setCategoryList(Arrays.asList(cat1));

        stateRepository.saveAll(Arrays.asList(s1, s2));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));
        clientRepository.save(cl1);
        adressRepository.saveAll(Arrays.asList(ad1, ad2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Order or1 = Order.builder().instant(sdf.parse("31/05/2021 20:58")).client(cl1).adressOrder(ad1).build();
        Order or2 = Order.builder().instant(sdf.parse("31/05/2021 20:58")).client(cl1).adressOrder(ad2).build();

        Payment pay1 = CreditCardPayment.builder().splitPrice(6).build();
        pay1.setOrder(or1);
        pay1.setStatePayment(StatePayment.QUITADO.getCode());

        Payment pay2 = CashPayment.builder().payDay(sdf.parse("31/05/2021 20:58")).dueDate(sdf.parse("31/05/2021 20:58")).build();
        pay2.setOrder(or2);
        pay2.setStatePayment(StatePayment.QUITADO.getCode());

        or1.setPayment(pay1);
        or2.setPayment(pay1);

        cl1.setOrdersList(Arrays.asList(or1, or2));

        orderRepository.saveAll(Arrays.asList(or1, or2));
        paymentRepository.saveAll(Arrays.asList(pay1, pay2));
    }
}
