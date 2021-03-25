package com.company;

class Route {
    public String origin;
    public String destination;

    public Route(String org, String dest) {
        origin = org;
        destination = dest;
    }

    public boolean verify(Route rt) {
        if(origin.equals(rt.destination ) && destination.equals(rt.origin))
            return true;
        else
            return false;
    }
    /*
    verifica daca sunt tur retur;
     */

}

class ClockTime {
    public int hour;
    public int minute;

    public ClockTime(int hr, int min) {
        hour = hr;
        minute = min;
    }

    public ClockTime() {
        this(0, 0);
    }

    public int compare(ClockTime c2) {
        if(this.hour > c2.hour || this.hour == c2.hour && this.minute > c2.minute)
            return 1;       // primul obiect e mai mare decat al 2 lea.
        if(this.hour < c2.hour || this.hour == c2.hour && this.minute < c2.minute)
            return 2;       // al 2 lea obiect e mai mare decat primul.
        return 0;           // sunt egale
    }
    /*
    - compar 2 momente de timp;
     */
    public String toString() {
        if(minute <= 9)
            return "(" + hour + ":0" + minute + ")";
        else
            return "(" + hour + ":" + minute + ")";
    }
}

class Schedule {
    public ClockTime departure;
    public ClockTime arrival;

    public Schedule(ClockTime departure, ClockTime arrival) {
        this.departure = new ClockTime(departure.hour, departure.minute);
        this.arrival = new ClockTime(arrival.hour, arrival.minute);
    }

    public Schedule() {
        this.departure = new ClockTime();
        this.arrival = new ClockTime();
    }

    public int term() {
        int res;

        if(arrival.compare(departure) <= 1) {
            if(arrival.hour == departure.hour)
                res = arrival.minute - departure.minute;
            else {
                if(arrival.minute >= departure.minute)
                    res = (arrival.hour - departure.hour) * 60 + arrival.minute - departure.minute;
                else {
                    int difH, difM;
                    difH = arrival.hour - departure.hour - 1;
                    difM = 60 + arrival.minute - departure.minute;
                    res = difH * 60 + difM;
                }
            }
        }else {
            int hr1, mn1;

            hr1 = 24 - departure.hour - 1;
            mn1 = 60 - departure.minute;
            res = hr1 * 60 + mn1 + arrival.hour * 60 + arrival.minute;
        }
        return  res;
    }
    /*
    - calculez diferenta in minute dintre 2 momente de timp;
    - avem 2 cazuri:
        a) daca timpul de sosire este mai mare decat cel de plecare( folosim func. compare);
        b) daca timpul de sosire este mai mic decat timpul de plecare, calatoria se desfasoara
        pe parcursul a 2 zile.
     */
}

class Train {
    public Route r;
    public Schedule s;
    public boolean local;

    public Train(Route rt, Schedule sc, boolean loc) {
        r = new Route(rt.origin, rt.destination);
        s = new Schedule(sc.departure, sc.arrival);
        local = loc;
    }

    public int price() {
        int X;

        if(local)
            X = 1;
        else
            X = 2;
        return X * s.term();
    }

    public String toString() {
        String str;

        str = local + " " + r.origin + " " + s.departure + " -> " +
                r.destination + " " + s.arrival;

        return str;
    }

    public static void main(String args[]) {
        Train t = new Train(new Route("Bucuresti Nord", "Constanta"),
                new Schedule(new ClockTime(9, 35), new ClockTime(12, 2)), true);
        Train t2 = new Train(new Route("Bucuresti Nord", "Iasi"),
                new Schedule(new ClockTime(5, 45), new ClockTime(12, 49)), true);
        Train t3 = new Train(new Route("Bucuresti Nord", "Sofia"),
                new Schedule(new ClockTime(23, 45), new ClockTime(17, 0)), false);
        System.out.println(t);
        System.out.println("Pretul pentru calatorie este: " + t.price());
        System.out.println(t2);
        System.out.println("Pretul pentru calatorie este: " + t2.price());
        System.out.println(t3);
        System.out.println("Pretul pentru calatorie este: " + t3.price());
    }
}