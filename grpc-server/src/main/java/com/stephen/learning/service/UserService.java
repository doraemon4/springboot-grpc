package com.stephen.learning.service;

import com.stephen.learning.grpc.service.UserServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

}
