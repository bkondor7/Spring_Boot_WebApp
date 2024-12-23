package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
//        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
//        for (OutsourcedPart part : outsourcedParts) {
//            System.out.println(part.getName() + " " + part.getCompanyName());
//        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        if (productRepository.count() == 0) {

            Product h2 = new Product("h2", 18999.99, 3);
            Product zx10r = new Product("zx10r", 16999.99, 5);
            Product zx6r = new Product("zx6r", 11999.99, 7);
            Product z1000 = new Product("z1000", 10999.99, 4);
            Product z900 = new Product("z900", 8999.99, 7);

            productRepository.save(h2);
            productRepository.save(zx10r);
            productRepository.save(zx6r);
            productRepository.save(z1000);
            productRepository.save(z900);
        }

        if (partRepository.count() == 0) {

            InhousePart superCharger = new InhousePart();
            superCharger.setName("Supercharger");
            superCharger.setPrice(4799.99);
            superCharger.setInv(5);
            superCharger.setId(1);
            superCharger.setMin(1);
            superCharger.setMax(30);
            partRepository.save(superCharger);

            InhousePart swingArm = new InhousePart();
            swingArm.setName("Swing Arm");
            swingArm.setPrice(2499.99);
            swingArm.setInv(5);
            swingArm.setId(2);
            swingArm.setMin(1);
            swingArm.setMax(30);
            partRepository.save(swingArm);

            InhousePart streetExhaust = new InhousePart();
            streetExhaust.setName("Street Exhaust");
            streetExhaust.setPrice(1299.99);
            streetExhaust.setInv(10);
            streetExhaust.setId(3);
            streetExhaust.setMin(1);
            streetExhaust.setMax(30);
            partRepository.save(streetExhaust);

            InhousePart intake = new InhousePart();
            intake.setName("Intake");
            intake.setPrice(109.99);
            intake.setInv(15);
            intake.setId(4);
            intake.setMin(1);
            intake.setMax(30);
            partRepository.save(intake);

            InhousePart tire = new InhousePart();
            tire.setName("Tire");
            tire.setPrice(95.99);
            tire.setInv(20);
            tire.setId(5);
            tire.setMin(1);
            tire.setMax(30);
            partRepository.save(tire);
        }

        if (outsourcedPartRepository.count() == 0) {

            OutsourcedPart turbo = new OutsourcedPart();
            turbo.setName("Turbo");
            turbo.setPrice(4999.99);
            turbo.setInv(5);
            turbo.setId(1);
            turbo.setMin(1);
            turbo.setMax(30);
            turbo.setCompanyName("JDMZ");
            outsourcedPartRepository.save(turbo);

            OutsourcedPart raceExhaust = new OutsourcedPart();
            raceExhaust.setName("Race Exhaust");
            raceExhaust.setPrice(2499.99);
            raceExhaust.setInv(10);
            raceExhaust.setId(2);
            raceExhaust.setMin(1);
            raceExhaust.setMax(30);
            raceExhaust.setCompanyName("JDMZ");
            outsourcedPartRepository.save(raceExhaust);

            OutsourcedPart tunedECU = new OutsourcedPart();
            tunedECU.setName("Tuned ECU");
            tunedECU.setPrice(1499.99);
            tunedECU.setInv(5);
            tunedECU.setId(3);
            tunedECU.setMin(1);
            tunedECU.setMax(30);
            tunedECU.setCompanyName("JDMZ");
            outsourcedPartRepository.save(tunedECU);

            OutsourcedPart NOSkit = new OutsourcedPart();
            NOSkit.setName("NOS kit");
            NOSkit.setPrice(1199.99);
            NOSkit.setInv(5);
            NOSkit.setId(4);
            NOSkit.setMin(1);
            NOSkit.setMax(30);
            NOSkit.setCompanyName("JDMZ");
            outsourcedPartRepository.save(NOSkit);

            OutsourcedPart raceTire = new OutsourcedPart();
            raceTire.setName("Race Tire");
            raceTire.setPrice(139.99);
            raceTire.setInv(20);
            raceTire.setId(5);
            raceTire.setMin(1);
            raceTire.setMax(30);
            raceTire.setCompanyName("JDMZ");
            outsourcedPartRepository.save(raceTire);
        }
//
//        System.out.println("Started in Bootstrap");
//        System.out.println("Number of Products" + productRepository.count());
//        System.out.println(productRepository.findAll());
//        System.out.println("Number of Parts" + partRepository.count());
//        System.out.println(partRepository.findAll());
//
    }
}
