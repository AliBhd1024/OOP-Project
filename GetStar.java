public enum GetStar {
    excellent,good,bad,awful;
    GetStar() {
    }
    static GetStar Star(String star) {
        if (star.equals("excellent"))
        {
            return excellent;
        }
       else if(star.equals("good"))
        {
            return good;
        }
       else if(star.equals("bad"))
        {
            return bad;
        }
       else
           return awful;
    }
}