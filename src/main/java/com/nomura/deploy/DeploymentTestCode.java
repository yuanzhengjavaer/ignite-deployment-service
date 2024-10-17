package com.nomura.deploy;

import org.apache.ignite.IgniteException;
import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.compute.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeploymentTestCode implements ComputeTask<String,Void>
{


    @Override
    public @Nullable Void reduce(List<ComputeJobResult> results) throws IgniteException {
        System.out.println("修正後reduce step!!!!!!!!!!!!!!!!!!!!");
        return null;
    }

    @Override
    public ComputeJobResultPolicy result(ComputeJobResult res, List rcvd) throws IgniteException {
        System.out.println("修正後result step!!!!!!!!!!!!!!!!!!!!");
        ComputeJobResult computeJobResult = new ComputeJobResult() {
            @Override
            public ComputeJobContext getJobContext() {
                return null;
            }

            @Override
            public <T> T getData() {
                return null;
            }

            @Override
            public IgniteException getException() {
                return null;
            }

            @Override
            public <T extends ComputeJob> T getJob() {
                return null;
            }

            @Override
            public ClusterNode getNode() {
                return null;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }
        };

        return ComputeJobResultPolicy.REDUCE;
    }
    @Override
    public @NotNull Map<? extends ComputeJob, ClusterNode> map(List<ClusterNode> subgrid, @Nullable String arg) throws IgniteException {

        System.out.println("修正後map step!!!!!!!!!!!!!!!!!!!!");
        ComputeJob job = new ComputeJob() {
            @Override
            public void cancel() {

            }

            @Override
            public Object execute() {
                return null;
            }
        };
        Map<ComputeJob,ClusterNode> jobs = new HashMap<>();
        jobs.put(job,subgrid.get(0));
        return jobs;
    }
}
