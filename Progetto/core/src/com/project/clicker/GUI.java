

/*

    public void CalcolaGuadagno(Database db){
        String optime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String cltime = db.getTime();
        Date date1 = new Date();
        Date date2 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            date1 = format.parse(optime);
            date2 = format.parse(cltime);
        } catch (ParseException p){
            p.printStackTrace();
        }
        long difference = date2.getTime() - date1.getTime();
        System.out.println(difference);

    }


}

 */
