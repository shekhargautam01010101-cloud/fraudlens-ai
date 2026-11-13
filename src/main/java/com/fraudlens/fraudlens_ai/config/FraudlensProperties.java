package com.fraudlens.fraudlens_ai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fraudlens")
public class FraudlensProperties {

    private Analysis analysis = new Analysis();
    private Security security = new Security();

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public static class Analysis {
        private double mlWeight = 0.40;
        private double graphWeight = 0.40;
        private double ruleWeight = 0.20;
        private double lowRiskThreshold = 40.0;
        private double mediumRiskThreshold = 69.0;
        private int isolationForestTrees = 100;
        private int isolationForestSubsampleSize = 256;
        private int fanInThreshold = 5;
        private int fanInWindowMinutes = 30;
        private int cycleWindowMinutes = 90;
        private int highRiskThreshold = 70;

        public double getMlWeight() { return mlWeight; }
        public void setMlWeight(double mlWeight) { this.mlWeight = mlWeight; }

        public double getGraphWeight() { return graphWeight; }
        public void setGraphWeight(double graphWeight) { this.graphWeight = graphWeight; }

        public double getRuleWeight() { return ruleWeight; }
        public void setRuleWeight(double ruleWeight) { this.ruleWeight = ruleWeight; }

        public double getLowRiskThreshold() { return lowRiskThreshold; }
        public void setLowRiskThreshold(double lowRiskThreshold) { this.lowRiskThreshold = lowRiskThreshold; }

        public double getMediumRiskThreshold() { return mediumRiskThreshold; }
        public void setMediumRiskThreshold(double mediumRiskThreshold) { this.mediumRiskThreshold = mediumRiskThreshold; }

        public int getIsolationForestTrees() { return isolationForestTrees; }
        public void setIsolationForestTrees(int isolationForestTrees) { this.isolationForestTrees = isolationForestTrees; }

        public int getIsolationForestSubsampleSize() { return isolationForestSubsampleSize; }
        public void setIsolationForestSubsampleSize(int isolationForestSubsampleSize) { this.isolationForestSubsampleSize = isolationForestSubsampleSize; }

        public int getFanInThreshold() { return fanInThreshold; }
        public void setFanInThreshold(int fanInThreshold) { this.fanInThreshold = fanInThreshold; }

        public int getFanInWindowMinutes() { return fanInWindowMinutes; }
        public void setFanInWindowMinutes(int fanInWindowMinutes) { this.fanInWindowMinutes = fanInWindowMinutes; }

        public int getCycleWindowMinutes() { return cycleWindowMinutes; }
        public void setCycleWindowMinutes(int cycleWindowMinutes) { this.cycleWindowMinutes = cycleWindowMinutes; }

        public int getHighRiskThreshold() { return highRiskThreshold; }
        public void setHighRiskThreshold(int highRiskThreshold) { this.highRiskThreshold = highRiskThreshold; }
    }

    public static class Security {
        private String username = "admin";
        private String password = "$2a$12$5LZ2N7w1wE.eF2kES8XNxO4d6V4bJ8A0iX7KQk5cC8d2wz3c4B1eO";

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
