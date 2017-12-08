public class chuangjianwenjuan {
    static int toInt(String strNum ) {
        Integer integer = new Integer(strNum);
        return integer.parseInt(strNum); }
    static boolean duicuo(String a){
        boolean t=true;
        boolean f=false;
        if(a.equals("true"))
            return t;
        else return f;
    }
}
