package io.arrogantprogrammer.kubelibs.sourcematerial.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class TextSourceRepository implements PanacheRepository<TextSource> {
}
