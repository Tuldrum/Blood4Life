package blood4life.server.domain.services;

import java.util.List;

import blood4life.commons.domain.Sangre;
import blood4life.server.access.ISangreRepository;

public class SangreService {
    private ISangreRepository repo;
    
    public SangreService(ISangreRepository repo) {
        this.repo = repo;
    }

    public synchronized Sangre find(int sangreId) {
        return repo.find(sangreId);
    }

    public synchronized List<Sangre> getRepo () {
        return repo.getRepo();
    }
}
