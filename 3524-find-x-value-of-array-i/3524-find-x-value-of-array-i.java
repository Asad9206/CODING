class Solution {
    public long[] resultArray(int[] dorayaki, int bambooCopters) {
        // Nobita is keeping track of the previous gadget counts (remainders)
        int[] nobita = new int[bambooCopters];

        // Doraemon’s final plan: this will store the final counts of each remainder
        long[] dorasFinalPlan = new long[bambooCopters];

        // Going through each dorayaki (number in the input array)
        for (int i = 0; i < dorayaki.length; i++) {
            // Shizuka is preparing the current set of gadgets (current counts)
            int[] shizuka = new int[bambooCopters];

            // First, Shizuka handles the single current dorayaki
            shizuka[dorayaki[i] % bambooCopters]++;

            // Now we let Shizuka combine past gadget powers (using previous remainders)
            for (int j = 0; j < nobita.length; j++) {
                if (nobita[j] != 0) {
                    // Calculate the new gadget power (remainder after multiplication)
                    int remFromGadget = (j * (dorayaki[i] % bambooCopters)) % bambooCopters;
                    
                    // Add the combination to Shizuka’s gadget list
                    shizuka[remFromGadget] += nobita[j];
                }
            }

            // Updating Doraemon’s final plan with Shizuka’s current gadget data
            for (int j = 0; j < shizuka.length; j++) {
                dorasFinalPlan[j] += shizuka[j];
                // Nobita prepares for the next round with the new gadget info
                nobita[j] = shizuka[j];
            }
        }

        // Doraemon's gadget count result for each remainder
        return dorasFinalPlan;
    }
}