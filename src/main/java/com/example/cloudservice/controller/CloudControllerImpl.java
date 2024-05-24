package com.example.cloudservice.controller;

import com.example.cloudservice.service.CloudService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CloudControllerImpl implements CloudController {
    private final CloudService cloudService;
}
