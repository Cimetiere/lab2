package com.opstty;

import com.opstty.job.WordCount;
import org.apache.hadoop.util.ProgramDriver;
import com.opstty.job.Districts_with_trees;
import com.opstty.job.Existing_species;
import com.opstty.job.Count_by_kind;
import com.opstty.job.Max_height_per_kind_of_tree;
import com.opstty.job.Trees_sorted_by_height;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("Districts_with_trees", Districts_with_trees.class,
                    "A map/reduce program that returns the list of distinct districts containing trees.");
            programDriver.addClass("Existing_species", Existing_species.class,
                    "A map/reduce program that returns the list of existing species of trees.");
            programDriver.addClass("Count_by_kind", Count_by_kind.class,
                    "A map/reduce program that calculates the number of trees in each kind.");
            programDriver.addClass("Max_height_per_kind_of_tree", Max_height_per_kind_of_tree.class,
                    "A map/reduce program that calculates the height of the tallest tree in each kind.");
            programDriver.addClass("Trees_sorted_by_height", Trees_sorted_by_height.class,
                    "A map/reduce program that sorts the trees height from smallest to largest.");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
