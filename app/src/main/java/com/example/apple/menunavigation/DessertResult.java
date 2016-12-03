package com.example.apple.menunavigation;

import java.util.List;

/**
 * Created by apple on 12/3/2016 AD.
 */

public class DessertResult {


    private List<DessertBean> dessert;

    public List<DessertBean> getDessert() {
        return dessert;
    }

    public void setDessert(List<DessertBean> dessert) {
        this.dessert = dessert;
    }

    public static class DessertBean {
        /**
         * des_id : 1
         * des_menu : Nutella No Bake Cookies
         * des_directions : Place the butter, sugar, cocoa, milk, salt, and vanilla in a saucepan over medium heat and stir until melted and smooth. Bring to a boil. Boil 1 minute, while stirring constantly. Remove the pan from the heat and stir in Nutella until smooth and creamy. Add the oats and coconut and stir until combined and coated.Drop by large spoonfuls onto parchment or waxed paper. Flatten and shape, if desired. Let set until completely cooled. Store in a sealed container. Makes 24 large cookies.
         * des_image : http://www.office365thailand.com/food/NutellaNoBake.jpg
         */

        private String des_id;
        private String des_menu;
        private String des_directions;
        private String des_image;

        public String getDes_id() {
            return des_id;
        }

        public void setDes_id(String des_id) {
            this.des_id = des_id;
        }

        public String getDes_menu() {
            return des_menu;
        }

        public void setDes_menu(String des_menu) {
            this.des_menu = des_menu;
        }

        public String getDes_directions() {
            return des_directions;
        }

        public void setDes_directions(String des_directions) {
            this.des_directions = des_directions;
        }

        public String getDes_image() {
            return des_image;
        }

        public void setDes_image(String des_image) {
            this.des_image = des_image;
        }
    }
}
