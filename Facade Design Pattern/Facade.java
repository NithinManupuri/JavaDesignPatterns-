class ImagePath {
    public void setPath() {
        System.out.println("Setting path for image");
    }
}

class StoreImage {
    public void store() {
        System.out.println("Storing image");
    }
}

class UploadSocialMedia {
    public void upload() {
        System.out.println("Uploading to social media");
    }
}

interface PostImage {
    void uploadImage();
}

class DefaultPostImage implements PostImage {
    private ImagePath imagePath;
    private StoreImage storeImage;
    private UploadSocialMedia uploadSocialMedia;

    public DefaultPostImage() {
        this.imagePath = new ImagePath();
        this.storeImage = new StoreImage();
        this.uploadSocialMedia = new UploadSocialMedia();
    }

    public void uploadImage() {
        imagePath.setPath();
        storeImage.store();
        uploadSocialMedia.upload();
    }
}

class Main {
    public static void main(String[] args) {
        PostImage p = new DefaultPostImage();
        p.uploadImage();
    }
}
