package com.thinkbiganalytics.spark.rest.model;

import javax.annotation.Nonnull;

/**
 * A request to perform a transformation on a table.
 */
public class TransformRequest {

    /** Previous transformation result */
    private Parent parent;

    /** Scala script with transformation */
    private String script;

    /**
     * Gets the previous transformation result.
     *
     * @return the previous result
     */
    public Parent getParent() {
        return parent;
    }

    /**
     * Sets the previous transformation result.
     *
     * @param parent the previous result
     */
    public void setParent(@Nonnull final Parent parent) {
        this.parent = parent;
    }

    /**
     * Gets the Scala script with the transformation.
     *
     * @return the transformation script
     */
    public String getScript() {
        return script;
    }

    /**
     * Sets the Scala script with the transformation.
     *
     * @param script the transformation script
     */
    public void setScript(@Nonnull final String script) {
        this.script = script;
    }

    /**
     * Results of a previous transformation.
     */
    public static class Parent {

        /** Scala script with the transformation */
        private String script;

        /** Table containing the results */
        private String table;

        /**
         * Gets the Scala script with the transformation.
         *
         * @return the transformation script
         */
        public String getScript() {
            return script;
        }

        /**
         * Sets the Scala script with the transformation.
         *
         * @param script the transformation script
         */
        public void setScript(String script) {
            this.script = script;
        }

        /**
         * Gets the name of the table containing the results.
         *
         * @return the table name
         */
        public String getTable() {
            return table;
        }

        /**
         * Sets the name of the table containing the results.
         *
         * @param table the table name
         */
        public void setTable(String table) {
            this.table = table;
        }
    }
}