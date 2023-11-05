package vn.com.devmaster.project.managermaterial.SQL;

public class Sql {
    public final static String PRODUCT_FIND_IMAGE = "" +
            "select NAME name, DESCRIPTION des, NOTES note, IMAGE img, QUATITY qty,\n" +
            "    case\n" +
            "        when ISACTIVE = 1 then 'Còn bán'\n" +
            "        else 'Không còn sản phẩm'\n" +
            "    end TrangThai\n" +
            "from product";

    public final static String PRODUCT_FIND_NAME = "" +
            "select * from product p\n" +
            "where p.NAME like concat('%',:name,'%')";
    public final static String PRODUCT_FIND_BETWEEN = "" +
            "select * from product p\n" +
            "where p.PRICE between :value1 and :value2";
    public final static String PRODUCT_FIND_LESSTHAN = "" +
            "select * from product p\n" +
            "where p.PRICE <= :value3";
    public final static String PRODUCT_FIND_MORETHAN = "" +
            "select * from product p \n" +
            "where p.PRICE >= :value4";
    public final static String PRODUCT_IMAGE = "" +
//            " select p.ID id,product_images.NAME name,product_images.URL url from product_images inner join product p on product_images.ID_PRODUCT = p.ID\n" +
//            " where p.ID = ?";
            " select product_images.ID id,product_images.NAME name,product_images.URL url,ID_PRODUCT     " +
            " from product_images  where product_images.ID_PRODUCT = ?";

    public final static String FIND_PRODUCT_IMAGE = "" +
            "select product_images.ID id,product_images.NAME name,product_images.URL url,product_images.ID_PRODUCT\n" +
            "from product_images  where product_images.ID_PRODUCT = ?";
}
