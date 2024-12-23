Bohdan Kondor
Java Frameworks

C. Customize the HTML user interface for your customer’s application.
The user interface should include the shop name, the product names, and the names of the parts.

    mainscreen.html

        Line 14 - <title>Kondor Powersports</title>
        Line 19 - <h1>Kondor Powersports</h1>


D.  Add an “About” page to the application to describe your chosen customer’s company to
web viewers and include navigation to and from the “About” page and the main screen.

    about.html

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>About Page</title>
    </head>
    <body>
        <h1>
            Hot Rides!
        </h1>

        <a href="http://localhost:8080">Home</a>

        <p>At Kondor Powersprots, we believe in quality over quantity. That is why you will get the
        most value doing business with us. From your first bike to top-tier supersports, and every part in between.
        We have it all! Come see us!</p>
    </body>
    </html>



    mainscreen.html

       Line 20 - <h3><a th:href="@{about}">About Us</a></h3>


    MainScreenControllerr.java

       Line 56 - @RequestMapping("/about)
       Line 57 - public String about() {
       Line 58 - return "about";
       Line 59 - }

E.  Add a sample inventory appropriate for your chosen store to the application.
You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

    BootStrapData.java
        
        Line 72 - 161
    
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
            partRepository.save(superCharger);

            InhousePart swingArm = new InhousePart();
            swingArm.setName("Swing Arm");
            swingArm.setPrice(2499.99);
            swingArm.setInv(5);
            swingArm.setId(2);
            partRepository.save(swingArm);

            InhousePart streetExhaust = new InhousePart();
            streetExhaust.setName("Street Exhaust");
            streetExhaust.setPrice(1299.99);
            streetExhaust.setInv(10);
            streetExhaust.setId(3);
            partRepository.save(streetExhaust);

            InhousePart intake = new InhousePart();
            intake.setName("Intake");
            intake.setPrice(109.99);
            intake.setInv(15);
            intake.setId(4);
            partRepository.save(intake);

            InhousePart tire = new InhousePart();
            tire.setName("Tire");
            tire.setPrice(95.99);
            tire.setInv(20);
            tire.setId(5);
            partRepository.save(tire);
        }

        if (outsourcedPartRepository.count() == 0) {

            OutsourcedPart turbo = new OutsourcedPart();
            turbo.setName("Turbo");
            turbo.setPrice(4999.99);
            turbo.setInv(5);
            turbo.setId(1);
            outsourcedPartRepository.save(turbo);

            OutsourcedPart raceExhaust = new OutsourcedPart();
            raceExhaust.setName("Race Exhaust");
            raceExhaust.setPrice(2499.99);
            raceExhaust.setInv(10);
            raceExhaust.setId(2);
            outsourcedPartRepository.save(raceExhaust);

            OutsourcedPart tunedECU = new OutsourcedPart();
            tunedECU.setName("Tuned ECU");
            tunedECU.setPrice(1499.99);
            tunedECU.setInv(5);
            tunedECU.setId(3);
            outsourcedPartRepository.save(tunedECU);

            OutsourcedPart NOSkit = new OutsourcedPart();
            NOSkit.setName("NOS kit");
            NOSkit.setPrice(1199.99);
            NOSkit.setInv(5);
            NOSkit.setId(4);
            outsourcedPartRepository.save(NOSkit);

            OutsourcedPart raceTire = new OutsourcedPart();
            raceTire.setName("Race Tire");
            raceTire.setPrice(139.99);
            raceTire.setInv(20);
            raceTire.setId(5);
            outsourcedPartRepository.save(raceTire);
        }


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

    mainscreen.html

       Line 86 - <a th:href="@{/buyproduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3"
       Line 87 - onclick="if(!(confirm('Are you sure you want to buy this product')))return false">Buy Now</a>


    Product.java

        Line 108 - 
        Line 109 - public boolean buyProduct() {
        Line 110 -  if (this.inv > 0) {
        Line 111 -      this.inv--;
        Line 112 -      return true;
        Line 113 -   }
        Line 114 - return false;
        Line 115 - }


    AddProductController.java

        Line 176 - 188
    
         @GetMapping("/buyproduct")
        public String buyProduct(@RequestParam("productID") int theID, Model theModel) {
        ProductService productService = context.getBean(ProductServiceImpl.class);
        Product product = productService.findById(theID);
        if (product.getName() == null) {
            return "buyproducterror";
        }
        if (product.buyProduct()) {
            productService.save(product);
            return "buyproductconfirm";
        }
        return "buyproducterror";
    }

    
    buyproductconfirm.html

        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Purchase Confirmed</title>
        </head>
        <body>
            <h1>Your purchase was successful!</h1>
            <a href="http://localhost:8080">Home</a>
        </body>
        </html>


    buyproducterror.html

        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Purchase Failed</title>
        </head>
        <body>
            <h1>Your purchase was unsuccessful.</h1>
            <a href="http://localhost:8080">Home</a>
        </body>
        </html>


G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

    Part.java

       Line 6 - import javax.validation.constraints.Max;

       Line 32 - @Min(value = 1, message = "Need at least 1")
       Line 33 - @Column
       Line 34 - static Integer min;
       Line 35 - @Max(value = 30, message = "No more than 30")
       Line 36 - @Column
       Line 37 - static Integer max;

    Line 59 - 79
        
        public Part(long id, String name, double price, int inv, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        Part.min = min;
        Part.max = max;
        }

        public void validateMinMax() {
            this.inv = Math.max(min, Math.min(this.inv, max));
        }

        public void setMin(int min) { Part.min = min; }

        public void setMax(int max) { Part.max = max; }

        public int getMin() { return min; }

        public int getMax() { return max; }



    BootStrapData.java

       Line 94 - superCharger.setMin(1);
       Line 95 - superCharger.setMax(30);

       Line 103 - swingArm.setMin(1);
       Line 104 - swingArm.setMax(30);

       Line 112 - streetExhaust.setMin(1);
       Line 113 - streetExhaust.setMax(30);

       Line 121 - intake.setMin(1);
       Line 122 - intake.setMax(30);

       Line 130 - tire.setMin(1);
       Line 131 - tire.setMax(30);

       Line 142 - turbo.setMin(1);
       Line 143 - turbo.setMax(30);
       Line 144 - turbo.setCompanyName("JDMZ");

       Line 152 - raceExhaust.setMin(1);
       Line 153 - raceExhaust.setMax(30);
       Line 154 - raceExhaust.setCompanyName("JDMZ");

       Line 162 - tunedECU.setMin(1);
       Line 163 - tunedECU.setMax(30);
       Line 164 - tunedECU.setCompanyName("JDMZ");

       Line 172 - NOSkit.setMin(1);
       Line 173 - NOSkit.setMax(30);
       Line 174 - NOSkit.setCompanyName("JDMZ");

       Line 182 - raceTire.setMin(1);
       Line 183 - raceTire.setMax(30);
       Line 184 - raceTire.setCompanyName("JDMZ");


    
    InhousePartServiceImpl.java
       
       Line 54 - thePart.validateMinMax();

    
    OutsourcedPartServiceImpl.java

       Line 52 - thePart.validateMinMax();


    
    InhousePartForm.html

        Line 26 - 30

            <p><input type="text" th:field="*{min}" placeholder="Minimum Inventory" class="form-control mb-4 col-4" /></p>

            <p><input type="text" th:field="*{max}" placeholder="Maximum Inventory" class="form-control mb-4 col-4" /></p>

        
    
    OutsourcedPartForm.html

        Line 27 - 31

            <p><input type="text" th:field="*{min}" placeholder="Minimum Inventory" class="form-control mb-4 col-4" /></p>

            <p><input type="text" th:field="*{max}" placeholder="Maximum Inventory" class="form-control mb-4 col-4" /></p>



    application.properties

         Line 6 - spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102-kondor



Fixed Following issues:

    BootStrapData.java - commeneted out code as instructed by instructor
        Line 60-63, Line 187-193

    Part.java

    Line 35-37
    
    @Min(value = 0, message = "Min inventory value must be positive")
    Integer min = Integer.valueOf(1);
    Integer max = Integer.valueOf(30);

    Line 60-66

    public Part(long id, String name, double price, int inv, Integer min, Integer max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.min = min;
        this.max = max;
    }

    Line 73 - public void setMin(Integer min) { this.min = min; }

    Line 75 - public void setMax(Integer max) { this.max = max; }


    InhousePartForm.html - also fixed minor syntax errors and got rid of extra html tag at the top
        Line 22-25

        <p><input type="text" th:field="*{min}" placeholder="Minimum Inventory" class="form-control mb-4 col-4" /></p>
        <p th:if="${#fields.hasErrors('min')}" th:errors="*{min}">Inventory Error</p>
        <p><input type="text" th:field="*{max}" placeholder="Maximum Inventory" class="form-control mb-4 col-4" /></p>
        <p th:if="${#fields.hasErrors('max')}" th:errors="*{max}">Inventory Error</p>


    OutsourcedPartForm.html
        Line 23-26

        <p><input type="text" th:field="*{min}" placeholder="Minimum Inventory" class="form-control mb-4 col-4" /></p>
        <p th:if="${#fields.hasErrors('min')}" th:errors="*{min}">Inventory Error</p>
        <p><input type="text" th:field="*{max}" placeholder="Maximum Inventory" class="form-control mb-4 col-4" /></p>
        <p th:if="${#fields.hasErrors('max')}" th:errors="*{max}">Inventory Error</p>



H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.


    ValidateMinPartInv.java

        package com.example.demo.validators;

        import com.example.demo.domain.Part;

        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;

    public class ValidateMinPartInv implements ConstraintValidator<ValidMinPartInv, Part> {

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {

        return part.getInv() >= part.getMin();
        }
    }



    ValidatePartInv.java

        package com.example.demo.validators;

        import com.example.demo.domain.Part;
        import org.springframework.context.ApplicationContext;
        import org.springframework.beans.factory.annotation.Autowired;

        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;

    public class ValidatePartInv implements ConstraintValidator<ValidPartInv, Part> {

    @Autowired
    private ApplicationContext context;
    public static ApplicationContext myContext;

    @Override
    public void initialize(ValidPartInv constraintAnnotation) {

        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {

        return part.getInv() <= part.getMax();
        }
    }



    ValidMinPartInv.java

        package com.example.demo.validators;

        import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.*;

    @Documented
    @Constraint(validatedBy = ValidateMinPartInv.class)
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidMinPartInv {

    String message() default "Inventory must be above minimum capacity";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    }



    ValidPartInv.java

        package com.example.demo.validators;

        import javax.validation.Constraint;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;

    @Constraint(validatedBy = {ValidatePartInv.class})
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidPartInv {

    String message() default "Inventory value cannot exceed 30";
    Class [] groups() default {};
    Class [] payload() default {};
    }



    Part.java

        Line 4 - import com.example.demo.validators.ValidMinPartInv;
        Line 5 - import com.example.demo.validators.ValidPartInv;

        Line 21 - @ValidMinPartInv
        Line 22 - @ValidPartInv



I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.


    PartTest.java

        Line 160 - 174

        @Test
        void testMin() {
        partIn.setMin(1);
        assertEquals(partIn.getMin(),1);
        partOut.setMin(1);
        assertEquals(partOut.getMin(),1);
    }
    
        @Test
        void testMax() {
        partIn.setMax(30);
        assertEquals(partIn.getMax(),30);
        partOut.setMax(30);
        assertEquals(partOut.getMax(),30);
    }



J.  Remove the class files for any unused validators in order to clean your code.

    - @ValidDeletePart appears to have no usages, commented out pertaining lines and files




***** Post-submission revision #1 *****


Min/Max column implementation:


    Part.java

        Line 77 - public int getMin() { return min = Integer.valueOf(1); }
        Line 79 - public int getMax() { return max = Integer.valueOf(30); }



    mainscreen.html

        Line 39 - 40

        <th>Min</th>
        <th>Max</th>

        Line 49 - 50

        <td th:text="${tempPart.min}">1</td>
        <td th:text="${tempPart.max}">1</td>


Inventory Min/Max validation message display:


    InhousePartForm.html

        Line 27 - 31

    <div th:if="${#fields.hasErrors()}">
        <ul>
            <li th:each="err:${#fields.allErrors()}" th:text="${err}" class="error"/>
        </ul>
    </div>



    OutsourcedPartForm.html

        Line 31 - 35

    <div th:if="${#fields.hasErrors()}">
        <ul>
            <li th:each="err:${#fields.allErrors()}" th:text="${err}" class="error"/>
        </ul>
    </div>



***** Post-submission revision #2 *****

    Part.java

    Line 36 - 37
        Integer min;
        Integer max;


    Line 77 - public Integer getMin() { return this.min; }
    Line 79 - public Integer getMax() { return this.max; }

Updated validation messages to be more clear and concise:

    ValidMinPartInv.java

        Line 13 - String message() default "Inventory must be above minimum limit";

    ValidPartInv.java

        Line 14 - String message() default "Inventory value cannot exceed maximum limit";