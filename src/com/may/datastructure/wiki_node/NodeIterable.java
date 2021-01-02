package com.may.datastructure.wiki_node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.jsoup.nodes.Node;


public class NodeIterable implements Iterable<Node> {

    private Node root;

    /**
     * Creates an iterable starting with the given Node.
     *
     * @param root
     */
    public NodeIterable(Node root) {
        this.root = root;
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator(root);
    }

    /**
     * Inner class that implements the Iterator.
     *
     * @author downey
     *
     */
    private class NodeIterator implements Iterator<Node> {
        // this stack keeps track of the Nodes waiting to be visited
        Deque<Node> stack;

        /**
         * Initializes the Iterator with the root Node on the stack.
         *
         * @param node
         */
        public NodeIterator(Node node) {
            stack = new ArrayDeque<Node>();
            //System.out.println(root); // 태그 포함
            stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node next() {
            // if the stack is empty, we're done
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }

            // otherwise pop the next Node off the stack
            Node node = stack.pop();
            //System.out.println(node);

            // push the children onto the stack in reverse order
            List<Node> nodes = new ArrayList<Node>(node.childNodes());
            // System.out.println("+++" + node.childNodes());
            // [[ 알고리즘 - BOJ ] 2667. 단지번호붙이기]
            // []
            Collections.reverse(nodes); // 내림차순 정렬
            //System.out.println(nodes);
            // [[ 알고리즘 - BOJ ] 2667. 단지번호붙이기]
            // []
            for (Node child: nodes) {
                //System.out.println(child);
                // [ 알고리즘 - BOJ ] 2667. 단지번호붙이기
                stack.push(child);
            }
            return node;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}