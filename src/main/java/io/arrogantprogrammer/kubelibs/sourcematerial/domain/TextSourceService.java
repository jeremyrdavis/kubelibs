package io.arrogantprogrammer.kubelibs.sourcematerial.domain;

import io.arrogantprogrammer.kubelibs.sourcematerial.TextSourceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TextSourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextSourceService.class);

    @Inject
    TextSourceRepository textSourceRepository;

    @Transactional
    public TextSourceDTO addTextSource(TextSourceDTO dto) {

        TextSource textSource = new TextSource(dto.text(), dto.author(), dto.url());
        textSourceRepository.persist(textSource);
        return new TextSourceDTO(textSource.getId(), textSource.getAuthor(), textSource.getText(), textSource.getUrl());
    }

    public List allSources() {
        return textSourceRepository.listAll();
    }
}
