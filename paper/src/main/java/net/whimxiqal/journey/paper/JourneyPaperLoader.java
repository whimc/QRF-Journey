package net.whimxiqal.journey.paper;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import io.papermc.paper.plugin.loader.library.impl.MavenLibraryResolver;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.repository.RemoteRepository;

public class JourneyPaperLoader implements PluginLoader {

  private static String[] artifacts = { "com.zaxxer:HikariCP:5.0.1", "org.json:json:20231013",
      "org.spongepowered:configurate-yaml:4.2.0", "org.incendo:cloud-core:2.0.0",
      "org.incendo:cloud-paper:2.0.0-beta.10" };

  @Override
  public void classloader(PluginClasspathBuilder classpathBuilder) {
    MavenLibraryResolver resolver = new MavenLibraryResolver();
    for (String artifact : artifacts) {
      resolver.addDependency(new Dependency(new DefaultArtifact(artifact), null));
    }
    resolver.addRepository(
        new RemoteRepository.Builder("central", "default", MavenLibraryResolver.MAVEN_CENTRAL_DEFAULT_MIRROR)
            .build());

    classpathBuilder.addLibrary(resolver);
  }
}
