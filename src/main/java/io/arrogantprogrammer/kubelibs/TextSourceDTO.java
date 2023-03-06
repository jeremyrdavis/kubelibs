package io.arrogantprogrammer.kubelibs;

import java.net.URL;

public record TextSourceDTO(Long id, String text, String author, URL url){
}
