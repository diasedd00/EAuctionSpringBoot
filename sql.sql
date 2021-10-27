select * from sellers;
INSERT INTO sellers VALUES
(1, "No56, EC", "Bangalore", "abc@wells.com","Anna","Banes",9886473344,560100,"Karnataka"),
(2, "PO Box 34, Avenue St", "Chennai", "simon@wells.com","Simon","Perry",7886473344,690010,"Tamil Nadu");

select * from products;
select * from buyers;
select * from bids;
select * from buyer_bid;
INSERT INTO products VALUES
(1, "2022-01-01", "Painting", "The lost ring","Acrylic Painting",1,"Aryclic",1000),
(2, "2022-02-01", "Sculpture", "Brass Figurine depicting a woman from 17th century","Brass Figurine",1,"Brass",5000);


drop table sellers;