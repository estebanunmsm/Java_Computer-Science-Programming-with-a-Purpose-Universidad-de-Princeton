public class Clock {

    private int hours; // horas modificables
    private int minutes; // minutos modificables

    // Crea un reloj cuya hora inicial es h horas y m minutos.
    /**
     * Crea un reloj cuya hora inicial es h horas y m minutos.
     *
     * @param h horas (0-23)
     * @param m minutos (0-59)
     */
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Input invalido");
        }
        hours = h;
        minutes = m;
    }
    /**
     * Crea un reloj cuya hora inicial se especifica como una cadena,
     * utilizando el formato HH:MM.
     * Ej: 09:48
     */
    public Clock(String s) {
        // ^ y $ son anclas de inicio y fin respectivamente
        if (!s.matches("^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")) {
            throw new IllegalArgumentException("Input invalido");
        }
        String[] parts = s.split(":");
        hours = Integer.parseInt(parts[0]);
        minutes = Integer.parseInt(parts[1]);
    }

    // Devuelve una representación en cadena de este reloj,
    // utilizando el formato HH:MM.
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }


    /**
     * ¿Es la hora de este reloj anterior a la de aquel otro?
     *
     * @return true si la respuesta es afirmativa
     */
    public boolean isEarlierThan(Clock that) {
        return (this.hours < that.hours) ||
                (this.hours == that.hours && this.minutes < that.minutes);
    }

    // Añade 1 minuto a la hora de este reloj.
    public void tic() {
        minutes++;
        if (minutes >=   60) {
            minutes = 0;
            hours++;
            if (hours == 24) {
                hours = 0;
            }
        }
    }

    // Añade Δ minutos a la hora de este reloj.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("valor invalido de delta");
        }
        minutes += delta;
        hours += minutes / 60;
        minutes %= 60;
        hours %= 24;
        /*
        if (delta < 60) {
            minutes += delta;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
            else if (minutes > 60) {
                minutes = (minutes % 60);
                hours++;
                if (hours >= 24) {
                    hours = 0;
                }
            }
        }
        else if ((delta % 60) == 0) {
            hours += delta/60;
            if (hours == 24) {
                hours = 0;
            } else hours = hours - 24;
        }
        else {
            hours += delta/60;
            if (hours == 24) {
                hours = 0;
            } else hours = hours - 24;

            minutes += (delta % 60);
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            } else if (minutes > 60) {
                minutes = (minutes % 60);
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
        */
    }

    // Test de cliente
    public static void main(String[] args) {
        Clock clock1 = new Clock(10, 30);
        System.out.println(clock1.toString()); // Output: 10:30

        Clock clock2 = new Clock("23:45");
        System.out.println(clock2.toString()); // Output: 23:45

        System.out.println(clock1.isEarlierThan(clock2)); // Output: true

        clock1.tic();
        System.out.println(clock1.toString()); // Output: 10:31

        clock2.toc(75);
        System.out.println(clock2.toString()); // Output: 00:00
    }
}
