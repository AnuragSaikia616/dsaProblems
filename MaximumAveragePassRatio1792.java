import java.util.PriorityQueue;

public class MaximumAveragePassRatio1792 {

    public static class ClassRecord {

        public int pass;
        public int total;
        public double delta;

        public ClassRecord(final int cl[]) {
            this.pass = cl[0];
            this.total = cl[1];
            this.delta = getDelta();
        }

        public double getDelta() {
            return (
                (double) (pass + 1) / (double) (total + 1) -
                (double) pass / (double) total
            );
        }

        public ClassRecord addOneStudent() {
            this.pass += 1;
            this.total += 1;
            this.delta = getDelta();
            return this;
        }

        public int getPass() {
            return pass;
        }

        public void setPass(final int pass) {
            this.pass = pass;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(final int total) {
            this.total = total;
        }

        public void setDelta(final double delta) {
            this.delta = delta;
        }
    }

    /**
     * Calculates the maximum possible average pass ratio after adding extra students
     * to optimize class pass rates.
     *
     * Algorithm:
     * 1. Uses a max heap ordered by potential improvement (delta) if one student is added
     * 2. Greedily adds students to classes that would show most improvement
     * 3. Calculates final average pass ratio across all classes
     *
     * @param classes 2D array where each inner array contains [passing_students, total_students]
     * @param extraStudents Number of additional students to distribute
     * @return Maximum possible average pass ratio after optimal student distribution
     */
    public static double maxAverageRatio(
        final int classes[][],
        int extraStudents
    ) {
        // Create max heap ordered by delta (improvement from adding one student)
        final PriorityQueue<ClassRecord> pq = new PriorityQueue<>((a, b) ->
            Double.compare(b.delta, a.delta)
        );
        // Initialize heap with all classes
        for (final int[] record : classes) {
            pq.add(new ClassRecord(record));
        }

        // Add each extra student to class that would benefit most
        while (extraStudents-- > 0) {
            pq.add(pq.remove().addOneStudent());
        }

        // Calculate final average pass ratio
        double sum = 0;
        while (!pq.isEmpty()) {
            final ClassRecord cl = pq.remove();
            sum += (double) cl.pass / (double) cl.total;
        }

        return sum / classes.length;
    }

    public static void main(final String[] args) {
        final int classes[][] = { { 1, 2 }, { 3, 5 }, { 2, 2 } };
        final int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));
    }
}
