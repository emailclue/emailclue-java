package com.emailclue.api;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

import static com.google.common.base.Throwables.propagate;
import static com.google.common.io.Resources.getResource;

public class Util {

    public static String fixture(String resource) {
        URL url = getResource(resource);
        try {
            return Resources.toString(url, Charsets.UTF_8);
        } catch (IOException e) {
            throw propagate(e);
        }
    }

}
