public class Comment {

    private String comment;
    private GetStar star;
    private User user;
    public Comment(User user, String comment,GetStar star) {
        this.user = user;
        this.comment = comment.substring(1,comment.length()-1);
        this.star = star;
    }
    public User getUser() {
        return user;
    }
    public String getComment() {
        return comment;
    }
    public GetStar GetStar() {
        return star;
    }

}