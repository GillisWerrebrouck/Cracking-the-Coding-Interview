package CtCILibrary;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MultiStack {
    private int numberOfStacks;
    private int[] stacks;
    private int[] stackTopIndices;
    private int[] stackSizes;
    private int[] stackCapacities;
    private int totalCapacity;
    
    public MultiStack(int numberOfStacks, int stackSize) {
        if(numberOfStacks <= 0) {
            throw new NegativeArraySizeException("the number of stacks can't be negative");
        }

        this.numberOfStacks = numberOfStacks;
        this.stacks = new int[numberOfStacks * stackSize];
        this.stackTopIndices = new int[numberOfStacks];
        this.stackSizes = new int[numberOfStacks];
        this.stackCapacities = new int[numberOfStacks];
        this.totalCapacity = numberOfStacks * stackSize;

        for(int s = 0; s<numberOfStacks; s++) {
            this.stackTopIndices[s] = s*stackSize;
            this.stackSizes[s] = 0;
            this.stackCapacities[s] = stackSize;
        }
    }

    public int pop(int stackNumber) {
        if(stackNumber > numberOfStacks) {
            throw new IndexOutOfBoundsException("stack number out of bounds");
        }

        if(this.stackSizes[stackNumber] == 0) {
            throw new EmptyStackException();
        }

        int index = this.stackTopIndices[stackNumber] + this.stackSizes[stackNumber]-1;
        int value = this.stacks[index];
        this.stacks[index] = 0;
        this.stackSizes[stackNumber]--;

        return value;
    }

    public int peek(int stackNumber) {
        if(stackNumber > this.numberOfStacks) {
            throw new IndexOutOfBoundsException("stack number out of bounds");
        }

        if(this.stackSizes[stackNumber] == 0) {
            throw new EmptyStackException();
        }

        int index = this.stackTopIndices[stackNumber] + this.stackSizes[stackNumber]-1;
        return this.stacks[index];
    }

    public void push(int stackNumber, int value) {
        if(stackNumber >= numberOfStacks) {
            throw new IndexOutOfBoundsException("stack number out of bounds");
        }

        if(this.stackCapacities[stackNumber] == this.stackSizes[stackNumber]) {
            throw new StackOverflowError();
        }

        int index = this.stackTopIndices[stackNumber] + this.stackSizes[stackNumber];
        this.stacks[index] = value;
        this.stackSizes[stackNumber] += 1;
    }
}
