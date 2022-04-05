package com.jjohnston.structural.adapter;

/**
 * An adapter class lets you fit square pegs into round holes.
 * It extends the RoundPeg class to let the adapter objects act
 * as round pegs.
 */
public class SquarePegAdapter extends RoundPeg {

    // In reality, the adapter contains an instance of the
    // SquarePeg class.
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        // The adapter pretends that it's a round peg with a
        // radius that could fit the square peg that the adapter
        // actually wraps.

        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}
