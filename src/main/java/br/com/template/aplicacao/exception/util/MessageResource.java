package br.com.template.aplicacao.exception.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageResource {

    private static final MessageResource MESSAGE_RESOURCE = new MessageResource();

    private static final ReloadableResourceBundleMessageSource resourceBundleMessageSource = buildBundleMessageSource();

    public static synchronized MessageResource getInstance() {
        return MESSAGE_RESOURCE;
    }

    public String getMessage(String key) {
        return resourceBundleMessageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    private static ReloadableResourceBundleMessageSource buildBundleMessageSource() {
        var bundleMessageSource = new ReloadableResourceBundleMessageSource();
        bundleMessageSource.setBasename("classpath:messages");
        bundleMessageSource.setDefaultEncoding("ISO-8859-1");
        return bundleMessageSource;
    }
}