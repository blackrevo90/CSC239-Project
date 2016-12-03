package com.example.apple.menunavigation;


import java.util.List;

public class YoutubeResult {

    private List<YoutubeBean> youtube;

    public List<YoutubeBean> getYoutube() {
        return youtube;
    }

    public void setYoutube(List<YoutubeBean> youtube) {
        this.youtube = youtube;
    }

    public static class YoutubeBean {
        /**
         * id : obiX6uGNCEc
         * title : Ab Cardio Workout 1: Amrap | 30 DAY 6 PACK ABS
         * logo : http://www.office365thailand.com/youtube/befit.jpg
         * image : http://www.office365thailand.com/youtube/abcardio.jpg
         */

        private String id;
        private String title;
        private String logo;
        private String image;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
