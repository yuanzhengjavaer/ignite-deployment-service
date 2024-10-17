package com.nomura;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.deployment.uri.UriDeploymentSpi;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        IgniteConfiguration cfg = new IgniteConfiguration();
        UriDeploymentSpi uriDeploymentSpi = new UriDeploymentSpi();
        uriDeploymentSpi.setUriList(Arrays.asList("file://freq=2000@localhost/Users/yuanzheng/Desktop/igniteUriDeploy/"));

        cfg.setDeploymentSpi(uriDeploymentSpi);

        try (Ignite ignite = Ignition.start(cfg)) {
            while(true){
                //execute the task represented by a class located in the "user_libs" directory
                ignite.compute().execute("com.nomura.deploy.DeploymentTestCode", null);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}