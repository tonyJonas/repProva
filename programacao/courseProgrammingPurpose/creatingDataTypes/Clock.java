public class Clock {
    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Input inválido");
        }
        this.hours = h;
        this.minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String timeString) {
        if (!timeString.matches("^\\d{2}:\\d{2}$")) {
            throw new IllegalArgumentException("Formato inválido");
        }

        int h = Integer.parseInt(timeString.substring(0, 2));
        int m = Integer.parseInt(timeString.substring(3));

        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Input inválido");
        }

        this.hours = h;
        this.minutes = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", this.hours, this.minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock timeString) {
        if (this.hours == timeString.hours && this.minutes < timeString.minutes){ 
            return true;
        } else if (this.hours < timeString.hours){
            return true;
        } else {
            return false;
        }
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        this.toc(1);
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int dif) {
        if (dif < 0) {
            throw new IllegalArgumentException("Número não pode ser negativo");
        }
        int totalMinutes = this.hours * 60 + this.minutes + dif;
        this.hours = (totalMinutes / 60) % 24;
        this.minutes = totalMinutes % 60;
    }

    // Test client
    public static void main(String[] args) {
        // Clock c1 = new Clock(15, 23);
        // c1.tic();
        // c1.toc(54);
        // System.out.println(c1);
    }
}
