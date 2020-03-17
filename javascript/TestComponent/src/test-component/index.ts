import { Rule, SchematicContext, Tree, url, apply, template, mergeWith } from '@angular-devkit/schematics';
import { getWorkspace } from '@schematics/angular/utility/config';
import { join, normalize } from 'path';
import { strings } from '@angular-devkit/core';

// You don't have to export the function as default. You can also have more than one rule factory
// per file.
export function setupOptions(host: Tree, options: any): Tree {
  const workspace = getWorkspace(host);
  if (!options.project) {
    options.project = Object.keys(workspace.projects)[0];
  }
  const project = workspace.projects[options.project];
  options.path = join(normalize(project.root), 'src');
  return host;
}


export function testComponent(_options: Schema): Rule {
  return (_tree: Tree, _context: SchematicContext) => {
    // const { name } = _options;
    // tree.create('hello.js', `console.log('Hello ${name}!')`);
    const sourceTemplates = url('./files');
    const sourceParameterizedTemplates = apply(sourceTemplates, [
      template({
        ..._options,
        ...strings,
      })
    ]);
    return mergeWith(sourceParameterizedTemplates);
  };
}

export interface Schema {
  name: string;
  project?: string;
}
