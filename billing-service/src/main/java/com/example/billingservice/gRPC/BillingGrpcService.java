package com.example.billingservice.gRPC;

import billing_service.BillingServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
}
